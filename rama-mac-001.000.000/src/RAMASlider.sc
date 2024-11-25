;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Actor)
(use System)

(class RAMASlider of View
	(properties
		dataTop 0
		dataBottom 0
		dataCur 0
		dataStep 0
		topY 0
		bottomY 0
		perct 0
		totalHeight 0
		active 1
		adjusting 0
	)

	(method (init)
		(= y topY)
		(self setHotspot: 31)
		(super init: &rest)
	)

	(method (setup)
		(= totalHeight (= dataTop (= dataBottom (= dataCur (= dataStep 0)))))
	)

	(method (positionThumb &tmp temp0 temp1)
		(if (or adjusting (and (not dataTop) (not dataBottom)))
			(return)
		)
		(if (= temp0 (self getTotalDistance:))
			(if (> temp0 300)
				(= temp0 (* (- dataCur dataTop) 10))
				(= temp1 (/ totalHeight 10))
				(= perct (Min 100 (/ temp0 temp1)))
			else
				(= perct
					(Min
						100
						(/ (* (Abs (- dataCur dataTop)) 100) temp0)
					)
				)
			)
			(= y (+ topY (/ (* perct (- bottomY topY)) 100)))
			(UpdateScreenItem self)
		)
	)

	(method (getTotalDistance &tmp temp0)
		(if totalHeight
			(return)
		)
		(= totalHeight (+ dataBottom (Abs dataTop)))
	)

	(method (adjust param1)
		(+= dataCur param1)
		(= dataCur (Min dataBottom (Max dataTop dataCur)))
		(self positionThumb:)
	)

	(method (doVerb))

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(event globalize:)
		(if (or (not active) (event claimed:))
			(return)
		)
		(if plane
			(event localize: plane)
		)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(or dataTop dataBottom)
			)
			(= temp1 (Event new:))
			(= adjusting 1)
			(= temp2 (- bottomY topY))
			(while 1
				(GetEvent evMOUSE temp1)
				(= y (Min bottomY (Max topY (temp1 y:))))
				(= temp0 (/ (* (- y topY) 100) temp2))
				(self updateData: temp0)
				(UpdateScreenItem self)
				(FrameOut)
				(if (== (temp1 type:) evMOUSERELEASE)
					(break)
				)
			)
			(temp1 dispose:)
			(= adjusting 0)
			(= temp0 (/ (* (- y topY) 100) temp2))
			(self updateData: temp0)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (updateData param1)
		(= dataCur (/ (* param1 totalHeight) 100))
		(self positionThumb:)
	)
)

