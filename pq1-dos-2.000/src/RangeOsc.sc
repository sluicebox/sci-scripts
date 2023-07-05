;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Motion)

(public
	RangeOsc 0
)

(class RangeOsc of Cycle
	(properties
		howManyCycles -1
		firstC 0
		lastC 0
	)

	(method (init param1 param2 param3 param4 param5)
		(if (>= argc 2)
			(= howManyCycles param2)
		)
		(if (>= argc 5)
			(= caller param5)
		)
		(super init: param1)
		(if (>= argc 3)
			(= firstC param3)
			(if (>= argc 4)
				(if param4
					(= lastC param4)
				else
					(= lastC (client lastCel:))
				)
			else
				(= lastC (client lastCel:))
			)
		)
		(client cel: firstC)
	)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) lastC) (< temp0 firstC))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
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

