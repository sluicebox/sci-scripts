;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 978)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)

(class GameControls of IconBar
	(properties
		height 200
		state 0
		okButton 0
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 [temp5 10])
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(|= state $0020)
		(if (IsObject window)
			(window open:)
		else
			(= window
				((gSystemWindow new:)
					top: 46
					left: 24
					bottom: 155
					right: 296
					priority: 15
					open:
					yourself:
				)
			)
		)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 temp3))
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
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

	(method (dispatchEvent event &tmp eO thisIcon thePort [buffer 50] eType eMsg)
		(= eType (event type:))
		(= eMsg (event message:))
		(cond
			((== eType evHELP)
				(if
					(and
						(= thisIcon (self firstTrue: #onMe event))
						(thisIcon helpVerb:)
					)
					(= thePort (GetPort))
					(if (gSystemWindow respondsTo: #eraseOnly)
						(= eO (gSystemWindow eraseOnly:))
						(gSystemWindow eraseOnly: 1)
						(if (& gMsgType $0002)
							(DoAudio
								audPLAY
								(thisIcon modNum:)
								(thisIcon noun:)
								(thisIcon helpVerb:)
								0
								1
							)
						)
						(if (& gMsgType $0001)
							(Print
								font: gUserFont
								width: 250
								addText:
									(thisIcon noun:)
									(thisIcon helpVerb:)
									0
									1
									0
									0
									(thisIcon modNum:)
								init:
							)
						)
						(gSystemWindow eraseOnly: eO)
					else
						(if (& gMsgType $0002)
							(DoAudio
								audPLAY
								(thisIcon modNum:)
								(thisIcon noun:)
								(thisIcon helpVerb:)
								0
								1
							)
						)
						(if (& gMsgType $0001)
							(Print
								font: gUserFont
								width: 250
								addText:
									(thisIcon noun:)
									(thisIcon helpVerb:)
									0
									1
									0
									0
									(thisIcon modNum:)
								init:
							)
						)
					)
					(SetPort thePort)
				)
				(if helpIconItem
					(helpIconItem signal: (& (helpIconItem signal:) $ffef))
				)
				(gGame setCursor: 999)
				(return 0)
			)
			((& eType $0040) ; direction
				(switch eMsg
					(JOY_DOWN
						(cond
							(
								(and
									(IsObject highlightedIcon)
									(highlightedIcon respondsTo: #retreat)
								)
								(highlightedIcon retreat:)
								(return 0)
							)
							(
								(or
									(not (IsObject highlightedIcon))
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
									(IsObject highlightedIcon)
									(highlightedIcon respondsTo: #advance)
								)
								(highlightedIcon advance:)
								(return 0)
							)
							(
								(or
									(not (IsObject highlightedIcon))
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

	(method (select theIcon relVer)
		(theIcon select: (and (>= argc 2) relVer))
	)

	(method (advanceCurIcon &tmp theIcon))

	(method (swapCurIcon))

	(method (hide)
		(if window
			(window dispose:)
			(= window 0)
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
		selector 0
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

