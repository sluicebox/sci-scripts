;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 934)
(include sci.sh)
(use Main)
(use Interface)
(use IconBar)
(use System)

(public
	GameControls 0
)

(class Slider of IconI
	(properties
		sliderView 0
		sliderLoop 0
		sliderCel 0
		sTop 0
		sLeft 0
		sRight 0
		maxY 0
		minY 0
		underBits 0
		yStep 1
		theObj 0
		selector 0
		bottomValue 0
		topValue 0
	)

	(method (show)
		(super show: &rest)
		(if (not sRight)
			(= sLeft nsLeft)
			(= sRight nsRight)
			(= maxY (- nsBottom (CelHigh sliderView sliderLoop sliderCel)))
			(= minY nsTop)
		)
		(= sTop (self valueToPosn:))
		(DrawCel sliderView sliderLoop sliderCel sLeft sTop -1)
		(Graph grUPDATE_BOX (- nsTop 1) (- nsLeft 1) (+ 2 nsBottom) (+ 2 nsRight) 1)
	)

	(method (select relVer &tmp event)
		(if (and argc relVer)
			(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
				(event localize:)
				(cond
					((< (event y:) (- sTop yStep))
						(self move: yStep (not (& signal $0200)))
					)
					((> (event y:) (+ sTop yStep))
						(self move: (- yStep) (not (& signal $0200)))
					)
				)
				(event dispose:)
			)
			(if (& signal $0200)
				(self doit: (self posnToValue: sTop))
			)
			(event dispose:)
		else
			(return 1)
		)
	)

	(method (highlight))

	(method (move amount doSend &tmp newTop cHigh pnv newValue i dir retVal doSendTmp)
		(= doSendTmp (or (not argc) doSend))
		(= dir (sign amount))
		(for
			((= i amount))
			(<= yStep (Abs i))
			((-= i (* yStep dir)))
			
			(= newTop (- sTop (* dir yStep)))
			(= cHigh (CelHigh sliderView sliderLoop sliderCel))
			(= sTop
				(cond
					((< newTop minY) minY)
					((> newTop maxY) maxY)
					(else newTop)
				)
			)
			(= pnv (PicNotValid))
			(PicNotValid 1)
			(DrawCel view loop cel nsLeft nsTop -1)
			(DrawCel sliderView sliderLoop sliderCel sLeft sTop -1)
			(Graph grUPDATE_BOX (- nsTop 1) (- nsLeft 1) (+ 2 nsBottom) (+ 2 nsRight) 1)
			(PicNotValid pnv)
			(= newValue (self posnToValue: sTop))
			(= retVal
				(if doSendTmp
					(self doit: newValue)
				else
					(self doit:)
				)
			)
		)
		(return retVal)
	)

	(method (doit)
		(if theObj
			(Eval theObj selector &rest)
		)
	)

	(method (posnToValue yPosn)
		(return
			(+
				bottomValue
				(/ (* (- maxY yPosn) (- topValue bottomValue)) (- maxY minY))
			)
		)
	)

	(method (valueToPosn val &tmp selVal)
		(return
			(cond
				(
					(and
						(<
							(= selVal
								(if argc
									val
								else
									(self doit:)
								)
							)
							topValue
						)
						(< selVal bottomValue)
					)
					(if (< bottomValue topValue) maxY else minY)
				)
				((and (> selVal topValue) (> selVal bottomValue))
					(if (< bottomValue topValue) minY else maxY)
				)
				(else
					(+
						minY
						(/
							(* (Abs (- topValue selVal)) (- maxY minY))
							(Abs (- topValue bottomValue))
						)
					)
				)
			)
		)
	)

	(method (advance)
		(self
			move:
				(Max
					yStep
					(-
						sTop
						(self
							valueToPosn:
								(+
									(self doit:)
									(sign (- topValue bottomValue))
								)
						)
					)
				)
				(not (& signal $0200))
		)
		(if (& signal $0200)
			(self doit: (self posnToValue: sTop))
		)
	)

	(method (retreat)
		(self
			move:
				(Min
					(- yStep)
					(-
						sTop
						(self
							valueToPosn:
								(-
									(self doit:)
									(sign (- topValue bottomValue))
								)
						)
					)
				)
				(not (& signal $0200))
		)
		(if (& signal $0200)
			(self doit: (self posnToValue: sTop))
		)
	)
)

(class GameControls of IconBar
	(properties
		height 200
		state 0
		okButton 0
	)

	(method (show &tmp theX theY node nextNode obj)
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
		(= theX 30)
		(= theY 30)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(if (not (IsObject (= obj (NodeValue node))))
				(return)
			)
			(if (and (not (& (obj signal:) $0080)) (<= (obj nsRight:) 0))
				(obj show: theX theY)
				(= theX (+ 20 (obj nsRight:)))
			else
				(obj show:)
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

	(method (dispatchEvent event &tmp eO thisIcon thePort)
		(cond
			((and (& (event type:) evVERB) (== (event message:) JOY_DOWNLEFT))
				(= thisIcon (self firstTrue: #onMe event))
				(event dispose:)
				(if (and thisIcon (thisIcon helpStr:))
					(= thePort (GetPort))
					(cond
						((gSystemWindow respondsTo: #eraseOnly)
							(= eO (gSystemWindow eraseOnly:))
							(gSystemWindow eraseOnly: 1)
							(if (thisIcon helpModule:)
								(Print (thisIcon helpModule:) (thisIcon helpStr:))
							else
								(Printf 934 0 (thisIcon helpStr:)) ; "%s"
							)
							(gSystemWindow eraseOnly: eO)
						)
						((thisIcon helpModule:)
							(Print (thisIcon helpModule:) (thisIcon helpStr:))
						)
						(else
							(Printf 934 0 (thisIcon helpStr:)) ; "%s"
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
			((& (event type:) $0040) ; direction
				(switch (event message:)
					(JOY_DOWN
						(event dispose:)
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
						(event dispose:)
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

	(method (select)
		(if theObj
			(if (super select: &rest)
				(if (& signal $0040)
					((if gGameControls gGameControls else GameControls) hide:)
				)
				(Eval theObj selector)
			)
		else
			(super select: &rest)
		)
	)
)

