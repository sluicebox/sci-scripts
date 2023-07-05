;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 960)
(include sci.sh)
(use System)

(class TimedCue of Script
	(properties)

	(method (init who theSeconds theCycles)
		(super init: who who)
		(if (>= argc 2)
			(= seconds theSeconds)
			(if (>= argc 3)
				(= cycles theCycles)
			)
		)
	)

	(method (cue)
		(if (++ state)
			(self dispose:)
		)
	)
)

