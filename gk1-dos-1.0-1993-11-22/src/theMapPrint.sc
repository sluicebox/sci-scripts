;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use n013)
(use Print)
(use Actor)
(use System)

(public
	theMapPrint 0
)

(class IconI of View
	(properties
		nsTop -1
		loop -1
		cel -1
		signal 1
		helpVerb 0
		drawIt 1
	)

	(method (show)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (and (< view 10000) (IsHiRes))
			(= view (+ 10000 view))
		)
		(super init:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (< argc 2)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(>= temp0 nsLeft)
				(>= temp1 nsTop)
				(<= temp0 nsRight)
				(<= temp1 nsBottom)
			)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (!= self (IconMap highlightedIcon:))
			(if (== modNum -1)
				(= temp0 gCurRoomNum)
			)
			(if param1
				(if (theMapPrint dialog:)
					((theMapPrint dialog:) dispose:)
				)
				(FrameOut)
				(theMapPrint
					x: 0
					y: 160
					font: 0
					modeless: 2
					fore: 47
					back: 0
					addText: noun 0 0 0 0 0 temp0
					init:
				)
				(FrameOut)
			)
		)
	)

	(method (select &tmp [temp0 3])
		(return 1)
	)
)

(class IconMap of Set
	(properties
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		prevWaitCurs 0
	)

	(method (setOldCurs)
		(gWaitCursor view: 997)
		(gGame setCursor: gWaitCursor 1)
	)

	(method (show &tmp [temp0 5] temp5 temp6)
		(gGame handsOff:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(= prevWaitCurs gWaitCursor)
		(gWaitCursor view: 999)
		(gGame setCursor: gWaitCursor 1)
		(gNarrator modeless: 1)
		(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 nextNode))
			(= nextNode (NextNode temp5))
			(= temp6 (NodeValue temp5))
			(temp6 show:)
		)
		(ClearFlag 220)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (- gMouseY 10))
		(cond
			((not (= temp0 (self firstTrue: #onMe gMouseX temp1)))
				(if highlightedIcon
					(highlightedIcon highlight: 0)
					(= highlightedIcon 0)
				)
				((ScriptID gCurRoomNum 2) doit: gMouseX temp1)
			)
			((and temp0 (!= temp0 highlightedIcon))
				(self highlight: temp0 1)
			)
		)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(if (not (gCurRoom script:))
			(self dispatchEvent: event)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(= temp4 (self firstTrue: #onMe event))
		(if (& temp2 $0010) ; direction
			(switch temp3
				(JOY_RIGHT
					(self advance:)
				)
				(JOY_LEFT
					(self retreat:)
				)
			)
		else
			(switch temp2
				(evMOUSEBUTTON
					(cond
						((not temp4)
							(self noDest:)
						)
						((self select: temp4 1)
							(= temp5 1)
							(temp4 cue:)
						)
					)
				)
				(evKEYBOARD
					(switch temp3
						(KEY_ESCAPE
							(= temp5 1)
						)
						(KEY_DELETE
							(= temp5 1)
						)
						(KEY_RETURN
							(cond
								((not temp4)
									(self noDest:)
								)
								((self select: temp4 1)
									(= temp5 1)
									(temp4 cue:)
								)
							)
						)
						(KEY_SHIFTTAB
							(self retreat:)
						)
						(KEY_TAB
							(self advance:)
						)
					)
				)
			)
		)
		(return temp5)
	)

	(method (advance &tmp [temp0 2]))

	(method (retreat &tmp [temp0 2]))

	(method (goLeft &tmp [temp0 2]))

	(method (goRight &tmp [temp0 2]))

	(method (select param1 param2)
		(return
			(if (param1 select: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				1
			)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if highlightedIcon
			(highlightedIcon highlight: 0)
		)
		(= highlightedIcon param1)
		(param1 highlight: 1)
	)

	(method (dispose)
		(gWaitCursor view: 997)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gNarrator modeless: 2)
		(super dispose:)
	)

	(method (endDay)
		(switch gDay
			(2
				(if
					(and
						(IsFlag 107)
						(IsFlag 231)
						(IsFlag 232)
						(IsFlag 72)
					)
					(SetFlag 15)
					(return 1)
				)
			)
			(3
				(if
					(and
						(IsFlag 265)
						(IsFlag 21)
						(IsFlag 256)
						(gEgo has: 38) ; reconVeve
						(gEgo has: 8) ; wolfPhone
					)
					(SetFlag 15)
					(return 1)
				)
			)
			(4
				(if
					(and
						(IsFlag 447)
						(IsFlag 248)
						(IsFlag 36)
						(IsFlag 227)
						(gEgo has: 26) ; tatooTrace
						(gEgo has: 41) ; braceRep
					)
					(SetFlag 15)
					(return 1)
				)
			)
			(5
				(if (and (IsFlag 73) (IsFlag 16))
					(SetFlag 15)
					(return 1)
				)
			)
		)
	)
)

(instance theMapPrint of Print
	(properties
		width 319
		back 0
		x 0
	)

	(method (handleEvent)
		(return 0)
	)
)

