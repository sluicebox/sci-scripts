;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Motion)

(class FwdCount of Cycle
	(properties
		count 0
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(if (>= argc 2)
			(= caller param2)
			(= count (if (>= argc 3) param3 else 0))
		)
	)

	(method (doit &tmp temp0)
		(if (> (= temp0 (self nextCel:)) (client lastCel:))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(client cel: 0)
		(if (and count (not (-- count)))
			(= completed 1)
			(self motionCue:)
		)
	)
)

(class RdmC of FwdCount
	(properties
		prevCel -1
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(if (< count 0)
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(client cel: 0)
		(= completed 1)
		(self motionCue:)
	)

	(method (changeCel)
		(-- count)
		(Random 0 (client lastCel:))
	)
)

