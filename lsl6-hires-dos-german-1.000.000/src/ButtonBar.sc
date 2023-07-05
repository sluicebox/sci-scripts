;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use LL6Inv)
(use IconBar)
(use User)

(public
	ButtonBar 0
)

(class ButtonBar of IconBar
	(properties
		state 0
		x 0
		showInvAfter 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(super init:)
		(plane setRect: 0 0 320 200 picture: -2)
		(UpdatePlane plane)
		(= temp0 0)
		(for ((= temp1 (FirstNode elements))) temp1 ((= temp1 temp2))
			(= temp2 (NextNode temp1))
			(= temp3 (NodeValue temp1))
			(temp3 highlightColor: -1 posn: temp0 0)
			(SetNowSeen temp3)
			(+= temp0 (CelWide (temp3 view:) (temp3 loop:) (temp3 cel:)))
		)
		(plane setSize:)
		(plane
			setRect:
				x
				y
				(+ temp0 (- x 4))
				(+ y (- (plane bottom:) (plane top:)))
			priority: (+ (GetHighPlanePri) 1)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event type:))
		(if (not (gGame isHandsOff:))
			(if gGraphMenuBar
				(gGraphMenuBar handleEvent: event)
			)
			(if gTextScroller
				(gTextScroller handleEvent: event)
			)
		)
		(event localize: plane)
		(= temp1 (self onMe: event))
		(cond
			((& state $0004))
			(
				(or
					(& temp0 evMOUSEBUTTON)
					(and (& temp0 evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(cond
					((& (event modifiers:) emSHIFT)
						(self advanceCurIcon:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(event claimed: 1)
					)
					((event modifiers:) 0)
					(temp1
						(if
							(and
								(self select: temp1 (& temp0 evMOUSEBUTTON))
								(not (& (temp1 signal:) $0002))
							)
							(= curIcon temp1)
							(if (curIcon cursorView:)
								(gGame setCursor: (curIcon getCursor:))
							else
								(event
									type: (curIcon type:)
									message: (curIcon message:)
								)
							)
						)
						(event plane: plane)
						(event claimed: 1)
					)
					(curIcon
						(event
							type: (curIcon type:)
							message: (curIcon message:)
						)
					)
				)
			)
		)
		(if (and (not (event claimed:)) (User canInput:))
			(event globalize:)
			(cond
				(
					(and
						temp1
						(or
							(!= temp1 (ScriptID 0 8)) ; icon5
							(and
								(== temp1 (ScriptID 0 8)) ; icon5
								(not (& ((ScriptID 0 8) signal:) $0004)) ; icon5
							)
						)
					)
					(if (not global209)
						(gGame setCursor: gNormalCursor)
						(= global209 1)
					)
				)
				(global209
					(gGame setCursor: (self getCursor:))
					(= global209 0)
				)
			)
			(if gInventory
				(gInventory handleEvent: event)
			)
		)
		(event localize: (gCast plane:))
	)

	(method (onMe param1 &tmp temp0)
		(return
			(if
				(and
					(== (= temp0 (self firstTrue: #onMe param1)) (ScriptID 0 8)) ; icon5
					(& ((ScriptID 0 8) signal:) $0004) ; icon5
				)
				0
			else
				temp0
			)
		)
	)

	(method (show &tmp temp0)
		(= temp0 gTheCursor)
		(super show: &rest)
		(gGame setCursor: temp0)
	)

	(method (advanceCurIcon)
		(if
			(or
				(not showInvAfter)
				(!= curIcon showInvAfter)
				(not (gInventory curIcon:))
				(& state $0004)
			)
			(if (curIcon isKindOf: LL6InvItem)
				(= curIcon (ScriptID 0 8)) ; icon5
			)
			(super advanceCurIcon: &rest)
		else
			(gGame setCursor: ((= curIcon (gInventory curIcon:)) getCursor:))
		)
	)

	(method (swapCurIcon &tmp temp0)
		(cond
			((& state $0004)
				(return)
			)
			(
				(and
					(!= curIcon (= temp0 (NodeValue (self first:))))
					(not (& (temp0 signal:) $0004))
				)
				(= prevIcon curIcon)
				(if (== (= curIcon (NodeValue (self first:))) (ScriptID 0 11)) ; iconExit
					(= curIcon (ScriptID 0 4)) ; icon1
				)
			)
			(
				(and
					prevIcon
					(not (& (prevIcon signal:) $0004))
					(== (= curIcon prevIcon) (ScriptID 0 11)) ; iconExit
				)
				(= curIcon (ScriptID 0 4)) ; icon1
			)
		)
		(gGame setCursor: (self getCursor:))
	)

	(method (advance)
		(return 0)
	)

	(method (retreat)
		(return 0)
	)

	(method (highlight)
		(return 0)
	)
)

