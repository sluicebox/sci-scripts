;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64924)
(include sci.sh)
(use Main)
(use TransPlane)
(use Str)
(use Array)
(use Print)
(use Game)
(use Actor)
(use System)

(local
	local0
)

(class Messager of Obj
	(properties
		caller 0
		disposeWhenDone 1
		oneOnly 0
		killed 0
		oldIconBarState 0
		curSequence 0
		lastSequence 0
		plain 0
		changeCursor 0
	)

	(method (sayRandom param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (== argc 5)
			(= temp1 param5)
		else
			(= temp1 gCurRoomNum)
		)
		(for
			((= temp0 1))
			(Message msgSIZE temp1 param1 param2 param3 temp0)
			((++ temp0))
		)
		(-- temp0)
		(= temp0 (Random 1 temp0))
		(self
			say: param1 param2 param3 temp0 (if (> argc 3) param4 else 0) temp1
		)
		(return temp0)
	)

	(method (sayPlain)
		(= plain 1)
		(self say: &rest)
	)

	(method (dispose)
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
		(if changeCursor
			(gGame setCursor: local0 1)
		)
		(= plain 0)
		(super dispose:)
	)

	(method (cue killIt)
		(if (and argc killIt)
			(= killed 1)
		)
		(if (or oneOnly killed)
			(self dispose:)
		else
			(FrameOut)
			(self nextMsg:)
		)
	)

	(method (say param1 param2 param3 param4 param5 param6 &tmp temp0)
		(if global148
			(global148 cueVal: 1 dispose:)
			(FrameOut)
		)
		(if changeCursor
			(= local0 (gGame setCursor: gTheArrowCursor 1))
		)
		(= oneOnly (= killed 0))
		(= lastSequence 0)
		(= caller 0)
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
		(if (and gMsgType (Message msgSIZE temp0 param1 param2 param3 curSequence))
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
		(if global148
			(global148 cueVal: 1 dispose:)
			(FrameOut)
		)
		(if changeCursor
			(= local0 (gGame setCursor: gTheArrowCursor 1))
		)
		(= oneOnly (= killed 0))
		(= caller 0)
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
		(= oneOnly (= killed 0))
		(= caller 0)
		(if argc
			(= caller aCaller)
		)
		(self nextMsg:)
	)

	(method (sayFormat whoCares theTalker ctrlString args &tmp len buffer aTalker)
		(if global148
			(global148 cueVal: 1 dispose:)
			(FrameOut)
		)
		(if changeCursor
			(= local0 (gGame setCursor: gTheArrowCursor 1))
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

	(method (nextMsg theMod theNoun theVerb theCase theSeq &tmp temp0 temp1 temp2 temp3 temp4 [temp5 5] temp10 temp11 temp12)
		(= temp1 0)
		(= temp2 0)
		(= temp1 (Str newWith: 400 {}))
		(if argc
			(= temp0
				(Message msgGET theMod theNoun theVerb theCase theSeq (temp1 data:))
			)
		else
			(= temp0 (Message msgNEXT (temp1 data:)))
		)
		(= temp4 (Message msgNEXT))
		(if (& gMsgType $0002)
			(= temp2 (IntArray with: 0 0 0 0 0))
			(Message 9 (temp2 data:)) ; msgLAST_MESSAGE
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
				(= temp10 gSystemPlane)
				(= temp11 (Print shadowText:))
				(= temp12 (Print fore:))
				(if (not plain)
					(Print fore: 13 shadowText: 1)
					(= gSystemPlane TransPlane)
				)
				(if (& gMsgType $0002)
					(temp0 modNum: theMod say: temp2 self)
				else
					(temp0
						modNum: theMod
						say: temp1 self theMod theNoun theVerb theCase theSeq
					)
				)
				(= gSystemPlane temp10)
				(Print fore: temp12 shadowText: temp11)
				(++ curSequence)
			else
				(self dispose:)
			)
		else
			(self dispose:)
		)
		(if temp2
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

(class cyclingCursor of Prop
	(properties
		view 996
		cycleCnt 0
	)

	(method (isModeless)
		(return 1)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (dispose)
		(gTalkers delete: self)
	)

	(method (init)
		(SetCursor view loop cel)
		(= cycleCnt gGameTime)
		(gTalkers add: self)
		(return self)
	)

	(method (doit &tmp temp0)
		(cond
			((!= gTheCursor self)
				(gTalkers delete: self)
			)
			((>= (Abs (- gGameTime cycleCnt)) cycleSpeed)
				(= cycleCnt gGameTime)
				(if (> (= temp0 (+ cel 1)) (self lastCel:))
					(= cel 0)
				else
					(= cel temp0)
				)
				(SetCursor view loop cel)
			)
		)
	)

	(method (posn param1 param2)
		(SetCursor param1 param2)
		(= x (= gMouseX param1))
		(= y (= gMouseY param2))
	)

	(method (setView param1)
		(= view param1)
		(self init:)
	)

	(method (setLoop param1)
		(= loop param1)
		(self init:)
	)

	(method (setCel param1)
		(= cel param1)
		(self init:)
	)

	(method (show)
		(SetCursor 1)
	)

	(method (hide)
		(SetCursor 0)
	)
)

