;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64939)
(include sci.sh)
(use Motion)

(class Osc of Cycle
	(properties
		howManyCycles -1
	)

	(method (init who howMany whoCares)
		(if (>= argc 2)
			(= howManyCycles howMany)
			(if (>= argc 3)
				(= caller whoCares)
			)
		)
		(super init: who)
	)

	(method (doit &tmp newCel)
		(if (!= (= newCel (self nextCel:)) (client cel:))
			(if (or (> newCel clientLastCel) (< newCel 0))
				(= cycleDir (- cycleDir))
				(self cycleDone:)
			else
				(client cel: newCel)
			)
		)
	)

	(method (cycleDone)
		(if howManyCycles
			(if (> howManyCycles 0)
				(-- howManyCycles)
			)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)

