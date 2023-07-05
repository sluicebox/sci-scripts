;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64924)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Print)
(use System)

(public
	Messager 0
	talkerSet 1
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
		(talkerSet dispose:)
		(= lastSequence 0)
		(if (and gTheIconBar disableIconBar)
			(gTheIconBar state: oldIconBarState)
			(= oldIconBarState 0)
		)
		(if caller
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

	(method (say param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= caller (= oneOnly (= killed 0)))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(if (and (> argc 3) param4)
			(= oneOnly 1)
			(= curSequence param4)
		else
			(= curSequence 1)
		)
		(if (> argc 4)
			(= caller param5)
		)
		(if (> argc 5)
			(= temp0 param6)
		else
			(= temp0 gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET temp0 param1 param2 param3 curSequence))
			(self nextMsg: temp0 param1 param2 param3 curSequence)
		else
			(Print
				addTextF:
					{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
					temp0
					param1
					param2
					param3
					curSequence
				init:
			)
			(self dispose:)
		)
	)

	(method (sayRange param1 param2 param3 param4 param5 param6 param7 &tmp temp0)
		(= caller (= oneOnly (= killed 0)))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(= oneOnly 1)
		(if (and (> argc 3) param4)
			(= curSequence param4)
		else
			(= curSequence 1)
		)
		(if (and (> argc 4) param5)
			(= oneOnly 0)
			(= lastSequence param5)
		else
			(= lastSequence curSequence)
		)
		(if (> argc 5)
			(= caller param6)
		)
		(if (> argc 6)
			(= temp0 param7)
		else
			(= temp0 gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET temp0 param1 param2 param3 curSequence))
			(self nextMsg: temp0 param1 param2 param3 curSequence)
		else
			(Print
				addTextF:
					{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
					temp0
					param1
					param2
					param3
					curSequence
				init:
			)
			(self dispose:)
		)
	)

	(method (sayNext aCaller)
		(= caller (= oneOnly (= killed 0)))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(if argc
			(= caller aCaller)
		)
		(self nextMsg:)
	)

	(method (sayFormat whoCares theTalker ctrlString args &tmp len buffer aTalker)
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
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
		(= msgkey 0)
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
					(= msgkey (IntArray with: 0 0 0 0 0))
					(Message 9 (msgkey data:)) ; msgLAST_MESSAGE
				)
				(aTalker modNum: theMod say: theBuf self msgkey)
				(++ curSequence)
			else
				(++ curSequence)
				(if (not gCuees)
					(= gCuees (Set new:))
				)
				(gCuees add: ((Cue new:) cuee: self cuer: self yourself:))
				(self dispose:)
			)
		else
			(self dispose:)
		)
		(if (and msgkey (& gMsgType $0002))
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

