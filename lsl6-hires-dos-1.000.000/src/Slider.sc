;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64934)
(include sci.sh)
(use IconBar)
(use System)

(class Slider of IconI
	(properties
		yStep 1
		sliderView 0
		sliderLoop 0
		sliderCel 0
		sLeft 0
		sTop 0
		sRight 0
		maxY 0
		minY 0
		theObj 0
		bottomValue 0
		topValue 0
		sliderObj 0
	)

	(method (show param1 param2 &tmp temp0)
		(|= signal $0020)
		(if argc
			(self posn: param1 param2)
			(SetNowSeen self)
		)
		((= sliderObj (IconI new:))
			mainView: sliderView
			mainLoop: sliderLoop
			mainCel: sliderCel
			posn: x y
			highlightColor: -1
			setPri: 2
			init: ((plane casts:) at: 0)
		)
		(self
			maskView: mainView
			maskLoop: mainLoop
			maskCel: mainCel
			state: 0
			signal: 4
			setPri: 1
		)
		(UpdateScreenItem self)
		(if (not sRight)
			(= sLeft nsLeft)
			(= sRight nsRight)
			(= maxY (- nsBottom (CelHigh sliderView sliderLoop sliderCel)))
			(= minY nsTop)
		)
		(= sTop (self valueToPosn:))
		(sliderObj posn: sLeft sTop)
	)

	(method (select relVer &tmp event)
		(if (and argc relVer)
			(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
				(event localize: plane)
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
			(sliderObj x: sLeft y: sTop)
			(= newValue (self posnToValue: sTop))
			(= retVal
				(if doSendTmp
					(self doit: newValue)
				else
					(self doit:)
				)
			)
		)
		(UpdateScreenItem sliderObj)
		(FrameOut)
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

