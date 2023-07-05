;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 938)
(include sci.sh)
(use Motion)

(class ROsc of Cycle
	(properties
		cycles -1
		firstC 0
		lastC 0
	)

	(method (init who howMany fCel lCel whoCares)
		(if (>= argc 2)
			(= cycles howMany)
		)
		(if (>= argc 5)
			(= caller whoCares)
		)
		(super init: who)
		(if (>= argc 3)
			(= firstC fCel)
			(if (>= argc 4)
				(if lCel
					(= lastC lCel)
				else
					(= lastC (client lastCel:))
				)
			else
				(= lastC (client lastCel:))
			)
		)
		(client cel: firstC)
	)

	(method (doit &tmp newCel)
		(if (or (> (= newCel (self nextCel:)) lastC) (< newCel firstC))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: newCel)
		)
	)

	(method (cycleDone)
		(if cycles
			(client cel: (self nextCel:))
			(if (> cycles 0)
				(-- cycles)
			)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)

