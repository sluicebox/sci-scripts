;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Motion)

(class OccasionalCycle of Cycle
	(properties
		lowerEnd 5
		upperEnd 6
		lowCycles 1
		upperCycles 1
		numCycles 1
		waitCycles 0
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(if argc
			(= client param1)
			(if (>= argc 2)
				(= cycleDir param2)
				(if (>= argc 3)
					(= lowerEnd param3)
					(if (>= argc 4)
						(= upperEnd param4)
						(if (>= argc 5)
							(= lowCycles param5)
							(if (>= argc 6)
								(= upperCycles param6)
							)
						)
					)
				)
			)
		)
		(= completed (= cycleCnt 0))
		(self cycleDone:)
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(cond
			(waitCycles
				(-- waitCycles)
			)
			((or (> temp0 (client lastCel:)) (< temp0 0))
				(if numCycles
					(-- numCycles)
					(client cel: temp0)
				else
					(self cycleDone:)
				)
			)
			(else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(= waitCycles (Random lowerEnd upperEnd))
		(= numCycles (Random lowCycles upperCycles))
		(client
			cel:
				(if (= cycleDir 1)
					0
				else
					(client lastCel:)
				)
		)
		(= cycleCnt (GetTime))
	)
)

