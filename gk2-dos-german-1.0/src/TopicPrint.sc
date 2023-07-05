;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use n011)
(use ScrollPrint)
(use Interface)
(use DButton)
(use System)

(class TopicPrint of ScrollPrint
	(properties
		width 210
		height 102
	)

	(method (addSelection)
		(if (not selects)
			(= selects (List new:))
			(= classButton TopicButton)
			(= yOff 0)
		)
		(super addSelection: &rest)
	)

	(method (init &tmp temp0)
		(if selects
			(= temp0 (self addButton: 0 1 3 0 1 24 yOff 21))
			(= yOff (temp0 nsBottom:))
			(selects add: temp0)
		)
		(= modeless 1)
		(super init: &rest)
	)
)

(class Topic of Obj
	(properties
		sceneNum 0
		flagNum 0
		readyFlagNum 0
		modNum 0
		noun 0
		subList 0
		nextRoomNum 0
		setFlag 1
	)

	(method (yo param1)
		(return
			(and
				(not (IsFlag flagNum))
				(or
					(and argc param1)
					(not readyFlagNum)
					(IsFlag readyFlagNum)
				)
				(or (not subList) (subList firstTrue: #yo))
			)
		)
	)

	(method (addMe)
		(if (self yo:)
			(TopicPrint addSelection: self noun 3 0 1)
		)
	)

	(method (setSubList param1 &tmp temp0)
		(= subList (List new:))
		(for ((= temp0 (= setFlag 0))) (< temp0 argc) ((++ temp0))
			(subList add: [param1 temp0])
		)
	)

	(method (releaseSub)
		(if (!= subList 0)
			(subList release:)
		)
	)

	(method (nextRoomCheck)
		(return 1)
	)
)

(class TopicButton of DButton
	(properties
		mode 0
		hiliteColor 15
		lowliteColor 10
	)

	(method (init)
		(= borderColor (= back (= skip -1)))
		(super init: &rest)
		(= borderColor (= back (= skip -1)))
	)

	(method (updatePlane)
		(UpdateScreenItem self)
		(super updatePlane: &rest)
	)

	(method (doit)
		(if
			(and
				value
				(value flagNum:)
				(or
					(value setFlag:)
					(and
						(value subList:)
						(not ((value subList:) firstTrue: #yo))
					)
				)
			)
			(SetFlag (value flagNum:))
		)
		(cond
			((not value) 0)
			((value subList:)
				(gCurRoom subTopicList: (value subList:))
			)
		)
		(super doit: &rest)
	)

	(method (hilite param1)
		(cond
			((and argc param1)
				(if (not (& state $0008))
					(++ y)
					(|= state $0008)
					(= fore hiliteColor)
				)
			)
			((& state $0008)
				(-- y)
				(&= state $fff7)
				(= fore lowliteColor)
			)
		)
		(self draw:)
		(UpdateScreenItem self)
	)

	(method (track param1 &tmp temp0 temp1 temp2)
		(if (== 1 (param1 type:))
			(if (!= (= temp2 ((TopicPrint dialog:) theItem:)) self)
				(temp2 hilite: 0)
			)
			(self hilite: 1)
			(self draw:)
			(UpdateScreenItem self)
			(FrameOut)
			(= temp1 0)
			(repeat
				(= param1 (Event new: 32768))
				(param1 localize: plane)
				(= temp0 (self onMe: param1))
				(if (!= temp1 temp0)
					(self hilite: temp0)
					(self draw:)
					(UpdateScreenItem self)
					(FrameOut)
					(= temp1 temp0)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
			)
			(return (if temp0 self else 0))
		else
			(return self)
		)
	)
)

