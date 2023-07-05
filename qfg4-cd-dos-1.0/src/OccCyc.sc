;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Motion)

(class OccCyc of Cycle
	(properties
		lowerEnd 5
		upperEnd 6
		waitCycles 0
		cycleCount 0
		numOfLoops 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(if (>= argc 2)
			(= client param1)
			(if (>= argc 3)
				(= cycleDir param3)
				(if (>= argc 4)
					(= lowerEnd param4)
					(if (>= argc 5)
						(= upperEnd param5)
						(if (>= argc 6)
							(= numOfLoops param6)
							(if (>= argc 7)
								(= caller param7)
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
				(self cycleDone:)
			)
			(else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(if (and numOfLoops (== cycleCount numOfLoops))
			(client
				cel:
					(if (= cycleDir 1)
						0
					else
						(client lastCel:)
					)
				cycler: 0
			)
			(if caller
				(caller cue:)
			)
			(self dispose:)
		else
			(++ cycleCount)
			(= waitCycles (Random lowerEnd upperEnd))
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
)

