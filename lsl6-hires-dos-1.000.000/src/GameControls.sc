;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64978)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use User)

(class GameControls of IconBar
	(properties
		state 0
		height 200
		okButton 0
	)

	(method (doit)
		(super doit: &rest)
		((User curEvent:) claimed: 1)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(|= state $0020)
		(if plane
			(plane priority: (+ (GetHighPlanePri) 1))
		else
			(= plane
				((gSystemPlane new:)
					left: 24
					top: 46
					right: 296
					bottom: 155
					priority: (+ (GetHighPlanePri) 1)
					init:
					yourself:
				)
			)
		)
		(UpdatePlane plane)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 temp3))
			(= temp3 (NextNode temp2))
			(if (not (= temp4 (NodeValue temp2)))
				(return)
			)
			(temp4 init: self)
			(if (and (not (& (temp4 signal:) $0080)) (<= (temp4 nsRight:) 0))
				(temp4 show: temp0 temp1)
				(= temp0 (+ 20 (temp4 nsRight:)))
			else
				(temp4 show:)
			)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(if curIcon
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(curIcon nsLeft:)
						(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
					)
					(- (curIcon nsBottom:) 3)
			)
		)
		(self doit: hide:)
	)

	(method (dispatchEvent event &tmp temp0 temp1 [temp2 51] temp53 temp54)
		(= temp53 (event type:))
		(= temp54 (event message:))
		(cond
			((== temp53 evHELP)
				(if
					(and
						(= temp1 (self firstTrue: #onMe event))
						(temp1 helpVerb:)
					)
					(Print
						font: gUserFont
						width: 250
						addText:
							(temp1 noun:)
							(temp1 helpVerb:)
							0
							1
							0
							0
							(temp1 modNum:)
						init:
					)
				)
				(if helpIconItem
					(helpIconItem signal: (& (helpIconItem signal:) $ffef))
				)
				(gGame setCursor: 999)
				(return 0)
			)
			((& temp53 $0010) ; direction
				(switch temp54
					(JOY_DOWN
						(cond
							(
								(and
									highlightedIcon
									(highlightedIcon respondsTo: #retreat)
								)
								(highlightedIcon retreat:)
								(return 0)
							)
							(
								(or
									(not highlightedIcon)
									(& (highlightedIcon signal:) $0100)
								)
								(self advance:)
								(return 0)
							)
						)
					)
					(JOY_UP
						(cond
							(
								(and
									highlightedIcon
									(highlightedIcon respondsTo: #advance)
								)
								(highlightedIcon advance:)
								(return 0)
							)
							(
								(or
									(not highlightedIcon)
									(& (highlightedIcon signal:) $0100)
								)
								(self retreat:)
								(return 0)
							)
						)
					)
					(else
						(super dispatchEvent: event)
					)
				)
			)
			(else
				(super dispatchEvent: event)
			)
		)
	)

	(method (select param1 param2)
		(param1 select: (and (>= argc 2) param2))
	)

	(method (advanceCurIcon &tmp temp0))

	(method (swapCurIcon))

	(method (hide)
		(self eachElementDo: #dispose release:)
		(if plane
			(plane deleteCast: self dispose:)
			(= plane 0)
		)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
	)
)

(class ControlIcon of IconI
	(properties
		theObj 0
	)

	(method (doit)
		(if theObj
			(if (& signal $0040)
				((if gGameControls gGameControls else GameControls) hide:)
			)
			(gGame panelObj: theObj panelSelector: selector)
		)
	)
)

