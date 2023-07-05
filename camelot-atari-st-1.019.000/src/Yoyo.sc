;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 960)
(include sci.sh)
(use Motion)

(class Yoyo of Cycle
	(properties
		howManyCycles 1
	)

	(method (init param1 param2 param3)
		(= howManyCycles (if (>= argc 2) param2 else 1))
		(= caller (if (>= argc 3) param3 else 0))
		(super init: param1)
	)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) (client lastCel:)) (< temp0 0))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(if (!= (-- howManyCycles) 0)
			(client cel: (self nextCel:))
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)

