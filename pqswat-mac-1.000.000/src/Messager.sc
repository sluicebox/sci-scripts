;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64924)
(include sci.sh)
(use Main)
(use ExitButton)
(use Str)
(use Array)
(use Print)
(use System)

(local
	local0
	local1
	local2
)

(class Messager of Obj
	(properties
		caller 0
		disposeWhenDone 1
		oneOnly 0
		killed 0
		disableIconBar 1
		oldIconBarState 0
		curSequence 0
		lastSequence 0
	)

	(method (dispose)
		(if (and local0 local2)
			(local2 dispose:)
			(= local2 0)
		)
		(if (talkerSet size:)
			(talkerSet dispose:)
		)
		(= lastSequence 0)
		(if (and gTheIconBar disableIconBar)
			(gTheIconBar state: oldIconBarState)
			(= oldIconBarState 0)
		)
		(if (and caller (== gNewRoomNum gCurRoomNum))
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees
				add:
					((Cue new:)
						cuee: caller
						cuer: self
						register: killed
						yourself:
					)
			)
		)
		(super dispose:)
	)

	(method (cue killIt)
		(if (and argc killIt)
			(= killed 1)
		)
		(if (or oneOnly killed)
			(self dispose:)
		else
			(self nextMsg:)
		)
	)

	(method (say args &tmp aNoun aVerb aCase aMod)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #perform disposeMyself)
		)
		(= aNoun (= aVerb (= aCase (= curSequence (= caller 0)))))
		(= oneOnly (= killed 0))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(= aNoun [args 0])
		(if (> argc 1)
			(= aVerb [args 1])
		)
		(if (> argc 2)
			(= aCase [args 2])
		)
		(if (and (> argc 3) [args 3])
			(= oneOnly 1)
			(= curSequence [args 3])
		else
			(= curSequence 1)
		)
		(if (> argc 4)
			(= caller [args 4])
		)
		(if (> argc 5)
			(= aMod [args 5])
		else
			(= aMod gCurRoomNum)
		)
		(if (not (and gMsgType (Message msgGET aMod aNoun aVerb aCase curSequence)))
			(if global102
				(Print
					addTextF:
						{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
						aMod
						aNoun
						aVerb
						aCase
						curSequence
					init:
				)
			)
			(= aMod 64994)
			(= aNoun 12)
			(= aVerb (= aCase 0))
			(= curSequence 1)
		)
		(self nextMsg: aMod aNoun aVerb aCase curSequence)
	)

	(method (sayRange args &tmp aNoun aVerb aCase aMod)
		(= aNoun (= aVerb (= aCase (= curSequence (= caller 0)))))
		(= oneOnly (= killed 0))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(= aNoun [args 0])
		(if (> argc 1)
			(= aVerb [args 1])
		)
		(if (> argc 2)
			(= aCase [args 2])
		)
		(= oneOnly 1)
		(if (and (> argc 3) [args 3])
			(= curSequence [args 3])
		else
			(= curSequence 1)
		)
		(if (and (> argc 4) [args 4])
			(= oneOnly 0)
			(= lastSequence [args 4])
		else
			(= lastSequence curSequence)
		)
		(if (> argc 5)
			(= caller [args 5])
		)
		(if (> argc 6)
			(= aMod [args 6])
		else
			(= aMod gCurRoomNum)
		)
		(if (not (and gMsgType (Message msgGET aMod aNoun aVerb aCase curSequence)))
			(Print
				addTextF:
					{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
					aMod
					aNoun
					aVerb
					aCase
					curSequence
				init:
			)
			(= aMod 64994)
			(= aNoun 12)
			(= aVerb (= aCase 0))
			(= curSequence 1)
		)
		(self nextMsg: aMod aNoun aVerb aCase curSequence)
	)

	(method (sayNext aCaller)
		(= caller (= oneOnly (= killed 0)))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(if argc
			(= caller aCaller)
		)
		(self nextMsg:)
	)

	(method (sayFormat whoCares theTalker ctrlString args &tmp len buffer aTalker)
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(= aTalker (self findTalker: theTalker))
		(= len (FindFormatLen ctrlString args &rest))
		(= caller whoCares)
		(= oneOnly 1)
		(= buffer (Str newWith: len {}))
		(buffer format: ctrlString args &rest)
		(aTalker say: buffer self)
		(buffer dispose:)
	)

	(method (nextMsg theMod theNoun theVerb theCase theSeq &tmp aTalker theBuf msgkey)
		(= theBuf (Str newWith: 400 {}))
		(if argc
			(= aTalker
				(Message msgGET theMod theNoun theVerb theCase theSeq (theBuf data:))
			)
		else
			(= aTalker (Message msgNEXT (theBuf data:)))
		)
		(if (& gMsgType $0002)
			(= msgkey (IntArray with: 0 0 0 0 0))
			(Message 9 (msgkey data:)) ; msgLAST_MESSAGE
		)
		(if
			(and
				aTalker
				(or
					(not lastSequence)
					(and lastSequence (<= curSequence lastSequence))
				)
			)
			(if (!= (= aTalker (self findTalker: aTalker)) -1)
				(talkerSet add: aTalker)
				(if (& gMsgType $0002)
					(if (proc4_22)
						(= local0 1)
					else
						(= local0 0)
					)
					(if local0
						(if local2
							(local2 dispose:)
							(= local2 0)
						)
						(= local1 (Print new:))
						(local1
							fore: 255
							x: 20
							y: 20
							width: 600
							font: 20071
							modeless: 2
							addText: (theBuf data:)
							init:
						)
						(= local2 (local1 dialog:))
						(gPrints delete: local1)
					)
					(aTalker modNum: theMod say: msgkey self)
				else
					(aTalker
						modNum: theMod
						say: theBuf self theMod theNoun theVerb theCase theSeq
					)
				)
				(++ curSequence)
			else
				(self dispose:)
			)
		else
			(self dispose:)
		)
		(if (& gMsgType $0002)
			(msgkey dispose:)
		)
		(theBuf dispose:)
	)

	(method (findTalker)
		(Print
			width: 200
			addText:
				{<Messager findTalker:>\n\tCan't find talker or\n\tfindTalker method not over-ridden}
			init:
		)
		(return gNarrator)
	)
)

(instance talkerSet of Set
	(properties)

	(method (dispose)
		(self
			eachElementDo: #caller 0
			eachElementDo: #dispose (gMessager disposeWhenDone:)
			release:
		)
		(super dispose:)
	)
)

(instance disposeMyself of Code
	(properties)

	(method (doit param1)
		(param1 dispose: (param1 disposeWhenDone:))
	)
)

