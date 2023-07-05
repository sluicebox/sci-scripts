;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64924)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Print)
(use Game)
(use System)

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
		oldMsgType 0
	)

	(method (dispose)
		(if (talkerSet size:)
			(talkerSet dispose:)
		)
		(= lastSequence 0)
		(if (and gTheIconBar oldIconBarState)
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
		(= gMsgType oldMsgType)
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
		(= lastSequence 0)
		(= oneOnly (= killed 0))
		(= caller 0)
		(if (and gTheIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(if (and gTheIconBar (!= gCurRoomNum 50)) ; interrogation
			(gTheIconBar disable:)
		)
		(if (and (< argc 2) (== param2 0))
		)
		(if (and (< argc 3) (== param3 0))
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
		(if
			(not
				(and
					gMsgType
					(Message msgGET temp0 param1 param2 param3 curSequence)
				)
			)
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
			(= temp0 64994)
			(= param1 12)
			(= param2 (= param3 0))
			(= curSequence 1)
		)
		(self nextMsg: temp0 param1 param2 param3 curSequence)
	)

	(method (sayRange param1 param2 param3 param4 param5 param6 param7 &tmp temp0)
		(= oneOnly (= killed 0))
		(= caller 0)
		(if (and gTheIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(if (and gTheIconBar (!= gCurRoomNum 50)) ; interrogation
			(gTheIconBar disable:)
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
		(if
			(not
				(and
					gMsgType
					(Message msgGET temp0 param1 param2 param3 curSequence)
				)
			)
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
			(= temp0 64994)
			(= param1 12)
			(= param2 (= param3 0))
			(= curSequence 1)
		)
		(self nextMsg: temp0 param1 param2 param3 curSequence)
	)

	(method (sayNext aCaller)
		(= oneOnly (= killed 0))
		(= caller 0)
		(if (and gTheIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(if (and gTheIconBar (!= gCurRoomNum 50)) ; interrogation
			(gTheIconBar disable:)
		)
		(if argc
			(= caller aCaller)
		)
		(self nextMsg:)
	)

	(method (sayFormat whoCares theTalker ctrlString args &tmp len buffer aTalker)
		(if (and gTheIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(if (and gTheIconBar (!= gCurRoomNum 50)) ; interrogation
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

	(method (nextMsg theMod theNoun theVerb theCase theSeq &tmp temp0 temp1 temp2 temp3)
		(= temp1 (Str newWith: 400 {}))
		(if argc
			(= temp0
				(Message msgGET theMod theNoun theVerb theCase theSeq (temp1 data:))
			)
		else
			(= temp0 (Message msgNEXT (temp1 data:)))
		)
		(= oldMsgType gMsgType)
		(= temp2 0)
		(if
			(and
				temp0
				(or
					(not lastSequence)
					(and lastSequence (<= curSequence lastSequence))
				)
			)
			(= temp3 temp0)
			(if (!= (= temp0 (self findTalker: temp0)) -1)
				(if (& gMsgType $0002)
					(= temp2 (IntArray with: 0 0 0 0 0))
					(Message 9 (temp2 data:)) ; msgLAST_MESSAGE
					(if
						(or
							(and (not global166) (== temp3 99))
							(== temp3 97)
							(== temp3 64)
						)
						(^= gMsgType $0002)
					)
				)
				(talkerSet add: temp0)
				(temp0 modNum: theMod say: temp1 self temp2)
				(++ curSequence)
			else
				(++ curSequence)
				(if (not gCuees)
					(= gCuees (Set new:))
				)
				(gCuees add: ((Cue new:) cuee: self cuer: self yourself:))
			)
		else
			(self dispose:)
		)
		(if (and temp2 (& gMsgType $0002))
			(temp2 dispose:)
		)
		(temp1 dispose:)
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

