;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Print)
(use System)

(public
	ScalerSpdVary 0
)

(class ScalerSpdVary of Code
	(properties
		client 0
		frontY 190
		backY 0
		frontSize 100
		backSize 0
		slopeNum 0
		slopeNumSpd 0
		slopeNumStp 0
		slopeDen 0
		const 0
		constSpd 0
		constStp 0
		frontSpeed 6
		backSpeed 5
		frontStep 3
		backStep 2
		whichSel 1
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 param9 param10)
		(if argc
			(= client param1)
			(= frontSize param2)
			(= backSize param3)
			(= frontY param4)
			(= backY param5)
		)
		(= slopeNum (- frontSize backSize))
		(if (not (= slopeDen (- frontY backY)))
			(Prints {<Scaler> frontY cannot be equal to backY})
			(return 0)
		)
		(if (> argc 5)
			(= whichSel param6)
			(if (> argc 6)
				(= frontSpeed param7)
				(= backSpeed param8)
				(= slopeNumSpd (- frontSpeed backSpeed))
				(= constSpd (- backSpeed (/ (* slopeNumSpd backY) slopeDen)))
				(if (> argc 8)
					(= frontStep param9)
					(= backStep param10)
					(= slopeNumStp (- frontStep backStep))
					(= constStp (- backStep (/ (* slopeNumStp backY) slopeDen)))
				)
			)
		)
		(= const (- backSize (/ (* slopeNum backY) slopeDen)))
		(self doit:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(cond
			(
				(<
					(= temp0
						(if (not whichSel)
							(client y:)
						else
							(client x:)
						)
					)
					backY
				)
				(= temp1 backSize)
				(= temp2 backSpeed)
				(= temp3 backStep)
			)
			((> temp0 frontY)
				(= temp1 frontSize)
				(= temp2 frontSpeed)
				(= temp3 frontStep)
			)
			(else
				(= temp1 (+ (/ (* slopeNum temp0) slopeDen) const))
				(if constSpd
					(= temp2 (+ (/ (* slopeNumSpd temp0) slopeDen) constSpd))
					(if constStp
						(= temp3
							(+ (/ (* slopeNumStp temp0) slopeDen) constStp)
						)
					)
				)
			)
		)
		(if constSpd
			(client moveSpeed: temp2)
			(if
				(and
					constStp
					(not
						(and
							(== (client xStep:) temp3)
							(== (client yStep:) temp3)
						)
					)
				)
				(client setStep: temp3 temp3 1)
			)
		)
		(= temp1 (/ (* temp1 128) 100))
		(client scaleX: temp1 scaleY: temp1)
	)
)

