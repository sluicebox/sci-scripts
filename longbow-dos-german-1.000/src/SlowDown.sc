;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 890)
(include sci.sh)
(use Motion)

(class SlowDown of MoveTo
	(properties
		cycleSpeed 12
		moveSpeed 12
		cycleCnt 4
		oldCycSpd 0
		oldMvSpd 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(if (>= argc 5)
			(= cycleSpeed param5)
			(if (>= argc 6)
				(= moveSpeed param6)
				(if (>= argc 7)
					(= cycleCnt param7)
				)
			)
		)
		(super init: param1 param2 param3 param4 &rest)
		(= oldCycSpd (client cycleSpeed:))
		(= oldMvSpd (client moveSpeed:))
	)

	(method (doit)
		(if
			(and
				(<= (Abs (- (client x:) x)) (* cycleCnt (client xStep:)))
				(<= (Abs (- (client y:) y)) (* cycleCnt (client yStep:)))
			)
			(client cycleSpeed: cycleSpeed moveSpeed: moveSpeed)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(client cycleSpeed: oldCycSpd moveSpeed: oldMvSpd)
		(super dispose: &rest)
	)
)

