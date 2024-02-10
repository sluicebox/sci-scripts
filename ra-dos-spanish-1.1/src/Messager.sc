;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 924)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class Messager of Obj
	(properties
		caller 0
		talkerList 0
		disposeWhenDone 1
		oneOnly 0
		killed 0
		oldIconBarState 0
	)

	(method (dispose &tmp temp0)
		(if talkerList
			(talkerList
				eachElementDo: #caller 0
				eachElementDo: #dispose 1
				dispose:
			)
			(= talkerList 0)
		)
		(gTheIconBar state: oldIconBarState)
		(= oldIconBarState 0)
		(= temp0 caller)
		(super dispose:)
		(if temp0
			(temp0 cue: killed)
		)
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

	(method (say param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 [temp4 20])
		(= temp0 (= temp1 (= temp2 0)))
		(= caller (= oneOnly (= killed 0)))
		(if (not oldIconBarState)
			(= oldIconBarState (gTheIconBar state:))
		)
		(if (> argc 5)
			(= temp3 param6)
		else
			(= temp3 gCurRoomNum)
		)
		(if (not talkerList)
			((= talkerList (Set new:)) add:)
		)
		(if (== param1 -1)
			(if (and (> argc 1) (IsObject param2))
				(= caller param2)
			)
			(self sayNext:)
		else
			(if (and (> argc 4) param5)
				(= caller param5)
			)
			(if (and (> argc 1) param2)
				(= temp0 param2)
			)
			(if (and (> argc 2) param3)
				(= temp1 param3)
			)
			(if (and (> argc 3) param4)
				(= oneOnly 1)
				(= temp2 param4)
			else
				(= temp2 1)
			)
			(= caller (if (and (> argc 4) param5) param5 else 0))
			(if
				(or
					(and
						(& gMsgType $0001)
						(Message msgGET temp3 param1 temp0 temp1 temp2)
					)
					0
				)
				(self sayNext: temp3 param1 temp0 temp1 temp2)
			else
				(Print
					addTextF:
						@temp4
						{<Messager> %d: %d, %d, %d, %d not found}
						temp3
						param1
						temp0
						temp1
						temp2
					init:
				)
				(self dispose:)
			)
		)
	)

	(method (sayNext theMod theNoun theVerb theCase theSeq &tmp temp0)
		(if (= temp0 (Message msgNEXT 0))
			(= temp0 (self findTalker: temp0))
			(talkerList add: temp0)
			(if argc
				(temp0 say: theNoun theVerb theCase theSeq self theMod)
			else
				(temp0 say: 0 0 0 0 self)
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
		(Prints {<Messager findTalker:> Can't find talker})
		(= gQuit 1)
	)
)

