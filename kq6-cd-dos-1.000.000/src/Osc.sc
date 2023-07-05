;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 939)
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
		(if (or (> (= newCel (self nextCel:)) (client lastCel:)) (< newCel 0))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: newCel)
		)
	)

	(method (cycleDone)
		(if howManyCycles
			(client cel: (self nextCel:))
			(if (> howManyCycles 0)
				(-- howManyCycles)
			)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)

