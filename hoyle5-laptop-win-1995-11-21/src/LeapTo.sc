;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1302)
(include sci.sh)
(use Main)
(use Motion)

(class LeapTo of MoveTo
	(properties
		z 0
		zStep 0
		zPart 0
		gz 64
	)

	(method (init param1 param2 param3 param4 param5 param6 &tmp temp0 temp1)
		(= temp0 (Abs (/ (- (param1 x:) param2) (param1 xStep:))))
		(if (> (= temp1 (Abs (/ (- (param1 y:) param3) (param1 yStep:)))) temp0)
			(= temp0 temp1)
		)
		(++ temp0)
		(if (<= argc 4)
			(super init: param1 param2 param3)
		else
			(super init: param1 param2 param3 param5)
			(if (>= argc 6)
				(= gz param6)
			)
		)
		(if (>= argc 3)
			(= z param4)
		)
		(= zPart (/ gz 2))
		(= zStep
			(+ (* temp0 zPart) (- (/ (* 256 (- z (param1 z:))) temp0) zPart))
		)
	)

	(method (doit)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(DoBresen self)
			(if completed
				(client z: z)
			else
				(+= zPart zStep)
				(client z: (+ (client z:) (/ zPart 256)))
				(if (>= zPart 0)
					(&= zPart $00ff)
				else
					(|= zPart $ff00)
				)
				(-= zStep gz)
			)
		)
	)
)

