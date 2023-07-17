;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use DButton)
(use DItem)
(use Plane)
(use Print)
(use System)

(local
	local0
)

(instance scrollPlane of Plane
	(properties)

	(method (setRect param1 param2 param3 param4)
		(super setRect: param1 param2 param3 (+ param2 local0) &rest)
	)
)

(class ScrollPrint of Print
	(properties
		font 50
		width 100
		fore 10
		margin 0
		modeless 1
		onScreen 0
		height 116
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (init)
		(if (gPanels contains: (ScriptID 27 0)) ; controlPlane
			((ScriptID 27 0) dispose:) ; controlPlane
		)
		(= local0 height)
		(= plane scrollPlane)
		(plane picture: -2)
		(self posn: 50 360)
		(if (> BAD_SELECTOR (+ height 14))
			(upBut client: self)
			(dwnBut client: self)
			(dialog add: upBut add: dwnBut)
		)
		(if BAD_SELECTOR
			(dialog
				add: selectInvBut
				add: cUpInvBut
				add: exitInvBut
				add: curInvArea
			)
			(= BAD_SELECTOR -1)
		)
		(super init: &rest)
	)

	(method (dispose)
		(if BAD_SELECTOR
			(BAD_SELECTOR release:)
			(= BAD_SELECTOR 0)
		)
		(= BAD_SELECTOR (= BAD_SELECTOR 0))
		(if (and BAD_SELECTOR (cUpInvBut scratch:))
			(gInventory firstTrue: #showSelf (gUser sel_712:))
		)
		(super dispose: &rest)
	)

	(method (BAD_SELECTOR &tmp temp0 temp1)
		(= temp1
			(if (!= (gCurRoom modNum:) -1)
				(gCurRoom modNum:)
			else
				gCurRoomNum
			)
		)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR (List new:))
			(= BAD_SELECTOR 0)
		)
		(= temp0 (self addButton: &rest 24 BAD_SELECTOR temp1))
		(BAD_SELECTOR add: temp0)
		(= BAD_SELECTOR (temp0 nsBottom:))
		(dialog mouseHiliting: 1)
		(return temp0)
	)

	(method (BAD_SELECTOR param1 &tmp temp0)
		(= temp0
			(cond
				((>= (+ param1 BAD_SELECTOR) 0)
					(- 0 BAD_SELECTOR)
				)
				((< (+ BAD_SELECTOR BAD_SELECTOR param1) (- height 4))
					(- height (+ BAD_SELECTOR BAD_SELECTOR 4))
				)
				(else param1)
			)
		)
		(+= BAD_SELECTOR temp0)
		(BAD_SELECTOR eachElementDo: #move 0 temp0)
		(BAD_SELECTOR eachElementDo: #draw)
		(FrameOut)
	)
)

(class ScrollButton of DButton
	(properties
		state 1
		client 0
		BAD_SELECTOR 0
		BAD_SELECTOR 25
	)

	(method (track param1 &tmp temp0 temp1 temp2)
		(if (== 1 (param1 type:))
			(= temp1 0)
			(= temp2 BAD_SELECTOR)
			(repeat
				(= param1 (Event new: 32768))
				(param1 localize: plane)
				(if (and (= temp0 (self onMe: param1)) (not (-- temp2)))
					(= temp2 BAD_SELECTOR)
					(client sel_707: BAD_SELECTOR)
				)
				(if (!= temp0 temp1)
					(if temp0
						(client sel_707: 1)
						(= cel 2)
						(++ textTop)
						(++ textBottom)
					else
						(= cel 0)
						(-- textTop)
						(-- textBottom)
					)
					(self draw:)
					(UpdateScreenItem self)
					(FrameOut)
					(= temp1 temp0)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
			)
			(if temp0
				(-- textTop)
				(-- textBottom)
			)
			(self hilite: (& state $0008))
			(return (if temp0 self else 0))
		else
			(return self)
		)
	)
)

(instance upBut of ScrollButton
	(properties
		x 4
		y 5
		view 130
		loop 3
		BAD_SELECTOR 9
	)
)

(instance dwnBut of ScrollButton
	(properties
		x 4
		y 91
		view 130
		loop 4
		BAD_SELECTOR -9
	)
)

(instance selectInvBut of DButton
	(properties
		state 1
		x 528
		y 7
		view 130
		loop 13
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((super handleEvent: event)
				(gUser sel_712: 62)
				((gUser sel_715:) update:)
			)
		)
	)
)

(instance cUpInvBut of DButton
	(properties
		x 528
		y 41
		view 130
		loop 14
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 0)
		)
		(= scratch (super handleEvent: event))
	)
)

(instance exitInvBut of DButton
	(properties
		x 528
		y 75
		view 130
		loop 11
	)

	(method (onMe param1)
		(return (or (super onMe: param1) (< (param1 y:) 0)))
	)
)

(instance curInvArea of DItem
	(properties
		state 1
		x 430
		y 1
	)

	(method (init)
		(= view (gCurInvView view:))
		(= loop (gCurInvView loop:))
		(= cel (gCurInvView cel:))
		(super init: &rest)
	)

	(method (handleEvent event)
		(= view (gCurInvView view:))
		(= loop (gCurInvView loop:))
		(= cel (gCurInvView cel:))
		(cond
			((event claimed:)
				(return 0)
			)
			((and (== (gUser sel_712:) 62) (!= (gCurInvView sel_716:) -1))
				(gUser sel_712: (gCurInvView verb:))
				((gUser sel_715:) update:)
			)
		)
	)
)

