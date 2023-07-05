;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 924)
(include sci.sh)
(use Main)
(use Print)
(use Game)
(use System)

(class Messager of Obj
	(properties
		caller 0
		disposeWhenDone 1
		oneOnly 0
		killed 0
		curSequence 0
		lastSequence 0
	)

	(method (dispose)
		(talkerSet dispose:)
		(if caller
			(if (not gSet)
				(= gSet (Set new:))
			)
			(gSet
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
			(if gFastCast
				(gFastCast release: dispose:)
				(= gFastCast 0)
			)
			(self dispose:)
		else
			(self sayNext:)
		)
	)

	(method (say args &tmp aNoun aVerb aCase aMod [buffer 20] i)
		(= aNoun (= aVerb (= aCase (= curSequence 0))))
		(if (== (= aNoun [args (= caller (= oneOnly (= killed 0)))]) -1)
			(if (and (> argc 1) (IsObject [args 1]))
				(= caller [args 1])
			)
			(self sayNext:)
		else
			(if (and (> argc 1) [args 1])
				(= aVerb [args 1])
			)
			(if (and (> argc 2) [args 2])
				(= aCase [args 2])
			)
			(if (and (> argc 3) [args 3])
				(= oneOnly 1)
				(= curSequence [args 3])
			else
				(= curSequence 1)
			)
			(= i 4)
			(if
				(and
					(> argc 4)
					[args i]
					(not (IsObject [args i]))
				)
				(= lastSequence [args i])
				(++ i)
				(= oneOnly 0)
			else
				(= lastSequence 0)
			)
			(if (and (> argc i) [args i])
				(= caller [args i])
			else
				(= caller 0)
			)
			(= aMod (if (> argc (++ i)) [args i] else gCurRoomNum))
			(if (Message msgGET aMod aNoun aVerb aCase curSequence)
				(self sayNext: aMod aNoun aVerb aCase curSequence)
			else
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
				(self dispose:)
			)
		)
	)

	(method (sayFormat theTalker ctrlString args &tmp len buffer aTalker)
		(= aTalker (self findTalker: theTalker))
		(= len (FindFormatLen ctrlString args &rest))
		(if (IsObject [args (- argc 2)])
			(= caller [args (- argc 2)])
		)
		(= oneOnly 1)
		(= buffer (Memory memALLOC_CRIT len))
		(Format buffer ctrlString args &rest)
		(aTalker say: buffer self)
		(Memory memFREE buffer)
	)

	(method (sayNext theMod theNoun theVerb theCase theSeq &tmp temp0 [temp1 200])
		(if argc
			(= temp0 (Message msgGET theMod theNoun theVerb theCase theSeq @temp1))
		else
			(= temp0 (Message msgNEXT @temp1))
		)
		(if
			(and
				temp0
				(or
					(not lastSequence)
					(and lastSequence (<= curSequence lastSequence))
				)
			)
			(if (!= (= temp0 (self findTalker: temp0)) -1)
				(talkerSet add: temp0)
				(temp0
					modNum: theMod
					say: @temp1 self theMod theNoun theVerb theCase theSeq
				)
				(++ curSequence)
			else
				(if gFastCast
					(gFastCast release: dispose:)
					(= gFastCast 0)
				)
				(self dispose:)
			)
		else
			(if gFastCast
				(gFastCast release: dispose:)
				(= gFastCast 0)
			)
			(self dispose:)
		)
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

