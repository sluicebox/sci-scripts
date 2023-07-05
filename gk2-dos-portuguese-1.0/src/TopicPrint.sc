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

	(method (BAD_SELECTOR)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR (List new:))
			(= classButton TopicButton)
			(= BAD_SELECTOR 0)
		)
		(super BAD_SELECTOR: &rest)
	)

	(method (init &tmp temp0)
		(if BAD_SELECTOR
			(= temp0 (self addButton: 0 1 3 0 1 24 BAD_SELECTOR 21))
			(= BAD_SELECTOR (temp0 nsBottom:))
			(BAD_SELECTOR add: temp0)
		)
		(= modeless 1)
		(super init: &rest)
	)
)

(class Topic of Obj
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		modNum 0
		noun 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 1
	)

	(method (BAD_SELECTOR param1)
		(return
			(and
				(not (IsFlag BAD_SELECTOR))
				(or
					(and argc param1)
					(not BAD_SELECTOR)
					(IsFlag BAD_SELECTOR)
				)
				(or (not BAD_SELECTOR) (BAD_SELECTOR firstTrue: #BAD_SELECTOR))
			)
		)
	)

	(method (BAD_SELECTOR)
		(if (self BAD_SELECTOR:)
			(TopicPrint BAD_SELECTOR: self noun 3 0 1)
		)
	)

	(method (BAD_SELECTOR param1 &tmp temp0)
		(= BAD_SELECTOR (List new:))
		(for ((= temp0 (= BAD_SELECTOR 0))) (< temp0 argc) ((++ temp0))
			(BAD_SELECTOR add: [param1 temp0])
		)
	)

	(method (BAD_SELECTOR)
		(if (!= BAD_SELECTOR 0)
			(BAD_SELECTOR release:)
		)
	)

	(method (BAD_SELECTOR)
		(return 1)
	)
)

(class TopicButton of DButton
	(properties
		mode 0
		BAD_SELECTOR 15
		BAD_SELECTOR 10
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
				(value BAD_SELECTOR:)
				(or
					(value BAD_SELECTOR:)
					(and
						(value BAD_SELECTOR:)
						(not ((value BAD_SELECTOR:) firstTrue: #BAD_SELECTOR))
					)
				)
			)
			(SetFlag (value BAD_SELECTOR:))
		)
		(cond
			((not value) 0)
			((value BAD_SELECTOR:)
				(gCurRoom BAD_SELECTOR: (value BAD_SELECTOR:))
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
					(= fore BAD_SELECTOR)
				)
			)
			((& state $0008)
				(-- y)
				(&= state $fff7)
				(= fore BAD_SELECTOR)
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

