;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64910)
(include sci.sh)
(use DIcon)
(use DItem)
(use System)

(class DSlider of DItem
	(properties
		type 7
		knob 0
		sLeft 0
		sTop 0
		sRight 0
		maxY 0
		minY 0
		sliderView -1
		sliderLoop 0
		sliderCel 0
		theObj 0
		bottomValue 0
		topValue 0
	)

	(method (init theList)
		(super init: theList)
		((= knob (DIcon new:))
			view: sliderView
			loop: sliderLoop
			cel: sliderCel
			init: theList
		)
		(= sLeft x)
		(= sTop (+ y (self valueToPosn: value)))
		(knob posn: sLeft sTop)
		(UpdateScreenItem knob)
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
				(self eval: (self posnToValue: sTop))
			)
			(event dispose:)
		else
			(return 1)
		)
	)

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
				(+
					y
					(cond
						((< newTop minY) minY)
						((> newTop maxY) maxY)
						(else newTop)
					)
				)
			)
			(= newValue (self posnToValue: sTop))
			(= retVal
				(if doSendTmp
					(self eval: newValue)
				else
					(self eval:)
				)
			)
		)
		(knob posn: sLeft sTop)
		(return retVal)
	)

	(method (eval)
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
									(self eval:)
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
									(self eval:)
									(sign (- topValue bottomValue))
								)
						)
					)
				)
				(not (& signal $0200))
		)
		(if (& signal $0200)
			(self eval: (self posnToValue: sTop))
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
									(self eval:)
									(sign (- topValue bottomValue))
								)
						)
					)
				)
				(not (& signal $0200))
		)
		(if (& signal $0200)
			(self eval: (self posnToValue: sTop))
		)
	)

	(method (setSize &tmp [temp0 2])
		(= nsLeft x)
		(= nsTop y)
		(= nsRight (- (+ nsLeft (CelWide view loop cel)) 1))
		(= nsBottom (- (+ nsTop (CelHigh view loop cel)) 1))
	)
)

