;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Motion)

(class Full of Cycle
	(properties
		count -1
	)

	(method (init theObj theCount whoCares)
		(super init: theObj whoCares)
		(if (>= argc 2)
			(= count theCount)
			(if (>= argc 3)
				(= caller whoCares)
			)
		)
		(self reinit:)
	)

	(method (reinit)
		(= cycleDir 1)
		(client cel: 0)
	)

	(method (doit &tmp curCel newCel)
		(= curCel (client cel:))
		(= newCel (self nextCel:))
		(cond
			((== curCel newCel))
			((> newCel (client lastCel:))
				(= cycleDir -1)
				(client cel: (- (client lastCel:) 1))
			)
			((< newCel 1)
				(self cycleDone:)
			)
			(else
				(client cel: newCel)
			)
		)
	)

	(method (cycleDone)
		(cond
			((== count -1)
				(self reinit:)
			)
			((<= (-- count) 0)
				(client cel: 0)
				(= completed 1)
				(self motionCue:)
			)
			(else
				(self reinit:)
			)
		)
	)
)

