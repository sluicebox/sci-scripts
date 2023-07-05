;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 934)
(include sci.sh)
(use Main)
(use IconBar)
(use System)

(public
	GameControls 0
)

(procedure (Eval obj sel)
	(obj sel: &rest)
)

(class Slider of IconI
	(properties
		sliderView 0
		sliderLoop 0
		sliderCel 0
		sTop 0
		sLeft 0
		sBottom 0
		sRight 0
		maxY 0
		minY 0
		underBits 0
		yStep 1
		yLast 0
		theObj 0
		selector 0
		minValue 0
		maxValue 0
	)

	(method (show)
		(super show: &rest)
		(if (not sRight)
			(= sLeft nsLeft)
			(= sRight nsRight)
			(= sTop (+ nsTop (/ (- nsBottom nsTop) 2)))
			(= maxY (- nsBottom (CelHigh sliderView sliderLoop sliderCel)))
			(= minY nsTop)
		)
		(DrawCel sliderView sliderLoop sliderCel sLeft sTop -1)
		(Graph grUPDATE_BOX (- nsTop 1) (- nsLeft 1) (+ 2 nsBottom) (+ 2 nsRight) 1)
	)

	(method (select relVer &tmp event)
		(if (and argc relVer)
			(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
				(event localize:)
				(cond
					((< (event y:) (- yLast yStep))
						(self advance:)
					)
					((> (event y:) (+ yLast yStep))
						(self retreat:)
					)
				)
				(event dispose:)
			)
			(event dispose:)
		else
			(return 1)
		)
	)

	(method (highlight))

	(method (move amount &tmp temp0 temp1 temp2 temp3)
		(= temp0 (- sTop (* yStep amount)))
		(= temp1 (CelHigh sliderView sliderLoop sliderCel))
		(= sTop
			(cond
				((< temp0 minY) minY)
				((> temp0 maxY) maxY)
				(else temp0)
			)
		)
		(= temp2 (PicNotValid))
		(= sBottom (+ sTop temp1))
		(PicNotValid 1)
		(DrawCel view loop cel nsLeft nsTop -1)
		(DrawCel sliderView sliderLoop sliderCel sLeft sTop -1)
		(Graph grUPDATE_BOX (- nsTop 1) (- nsLeft 1) (+ 2 nsBottom) (+ 2 nsRight) 1)
		(PicNotValid temp2)
		(= yLast sTop)
		(= temp3 (/ (* (- maxY yLast) (- maxValue minValue)) (- maxY minY)))
		(if theObj
			(Eval theObj selector temp3)
		)
	)

	(method (advance)
		(self move: 1)
	)

	(method (retreat)
		(self move: -1)
	)
)

(class GameControls of IconBar
	(properties
		height 200
		okButton 0
	)

	(method (show &tmp theX theY node nextNode obj)
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
		(self doit:)
	)

	(method (dispatchEvent event)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_DOWN
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
						((& (highlightedIcon signal:) $0100)
							(self advance:)
							(return 0)
						)
					)
				)
				(KEY_UP
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
						((& (highlightedIcon signal:) $0100)
							(self retreat:)
							(return 0)
						)
					)
				)
				(else
					(return (super dispatchEvent: event))
				)
			)
		else
			(return (super dispatchEvent: event))
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
		(&= state $ffdf)
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
				(GameControls hide:)
				(Eval theObj selector)
			)
		else
			(super select: &rest)
		)
	)
)

