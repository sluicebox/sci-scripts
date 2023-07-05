;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class VelocityMover of MoveTo
	(properties
		vel 30
		grav1x 160
		grav1y 100
		oldGravx 160
		oldGravy 100
		targetScale 0
		isScale 0
		willLand 0
		grav1 10
	)

	(method (readjustWell param1 param2)
		(if (OneOf param1 0 90 180 270)
			(= grav1x (- oldGravx (- (Random 1 20) 10)))
		else
			(= grav1x oldGravx)
		)
		(if (OneOf param2 0 90 180 270)
			(= grav1y (- oldGravy (- (Random 1 20) 10)))
		else
			(= grav1y oldGravy)
		)
	)

	(method (init param1 param2 param3 param4 param5 &tmp [temp0 3] temp3)
		(if argc
			(= vel 10)
			(= willLand (= isScale (= caller 0)))
			(= client param1)
			(if (> argc 1)
				(= grav1x param2)
				(= grav1y param3)
				(= oldGravx param2)
				(= oldGravy param3)
				(if (> argc 3)
					(= caller param4)
					(if (> argc 4)
						(= willLand param5)
					)
				)
			)
			(self moveDone:)
		else
			(= yLast (= xLast (= completed 0)))
			(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
			(if (= temp3 (client cycler:))
				(temp3 cycleCnt: b-moveCnt)
			)
			(InitBresen self)
		)
	)

	(method (onTarget)
		(if willLand
			(if
				(and
					(<= (Abs (- (client x:) grav1x)) 5)
					(<= (Abs (- (client y:) grav1y)) 5)
				)
				(= completed 1)
				(if caller
					(= gDoMotionCue 1)
					(return 1)
				else
					(self motionCue:)
					(return 1)
				)
			else
				(if (< vel 0)
					(+= vel 1)
				else
					(-= vel 1)
				)
				(return 0)
			)
		else
			(return 0)
		)
	)

	(method (moveDone &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 100])
		(if
			(and
				willLand
				(<= (Abs (- (client x:) grav1x)) 5)
				(<= (Abs (- (client y:) grav1y)) 5)
			)
			(= completed 1)
			(if caller
				(= gDoMotionCue 1)
				(return)
			else
				(self motionCue:)
				(return)
			)
		)
		(if (>= (= temp2 (+ (- 360 (client heading:)) 90)) 360)
			(-= temp2 360)
		)
		(if
			(>=
				(= temp1
					(+
						(- 360 (GetAngle (client x:) (client y:) grav1x grav1y))
						90
					)
				)
				360
			)
			(-= temp1 360)
		)
		(self readjustWell: temp1 temp2)
		(= temp3 (* (CosMult temp2 vel) 100))
		(= temp3
			(+ (client x:) (if (> (mod temp3 100) 44) 1 else 0) (/ temp3 100))
		)
		(= temp4 (* (SinMult temp2 vel) 100))
		(= temp4
			(-
				(client y:)
				(+ (if (> (mod temp4 100) 44) 1 else 0) (/ temp4 100))
			)
		)
		(= temp5
			(+
				(if (> (mod (= temp5 (* (CosMult temp1 grav1) 100)) 100) 44)
					1
				else
					0
				)
				(/ temp5 100)
			)
		)
		(= temp6
			(+
				(if (> (mod (= temp6 (* (SinMult temp1 grav1) 100)) 100) 44)
					1
				else
					0
				)
				(/ temp6 100)
			)
		)
		(= temp7 (+ temp5 temp3))
		(= temp8 (- temp4 temp6))
		(= vel
			(Sqrt
				(+
					(* (- temp7 (client x:)) (- temp7 (client x:)))
					(* (- (client y:) temp8) (- (client y:) temp8))
				)
			)
		)
		(client setHeading: (GetAngle (client x:) (client y:) temp7 temp8))
		(self x: temp7 y: temp8)
		(self init:)
	)

	(method (motionCue)
		(client posn: grav1x grav1y)
		(super motionCue:)
	)
)

