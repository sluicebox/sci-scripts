;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 934)
(include sci.sh)
(use IconBar)
(use System)

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

