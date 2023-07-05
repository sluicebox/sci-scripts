;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 874)
(include sci.sh)
(use Main)
(use Motion)

(class CycleBet of Cycle
	(properties
		startCel 0
		stopCel 1
		howManyTimes 1
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0)
		(super init: param1)
		(if (== param4 -1)
			(= howManyTimes -1)
		else
			(= howManyTimes (* param4 2))
		)
		(if (> argc 4)
			(= caller param5)
		)
		(= temp0 (client lastCel:))
		(= startCel (if (< param2 0) 0 else param2))
		(= stopCel (if (> param3 temp0) temp0 else param3))
		(= cycleDir (if (> param3 param2) 1 else -1))
		(client cel: startCel)
	)

	(method (doit &tmp temp0)
		(if (>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(client cel: (+ (client cel:) cycleDir))
			(= cycleCnt gGameTime)
			(if (or (== (client cel:) stopCel) (== (client cel:) startCel))
				(self cycleDone:)
			)
		)
	)

	(method (cycleDone)
		(cond
			((== howManyTimes -1)
				(if (== cycleDir 1)
					(= cycleDir -1)
				else
					(= cycleDir 1)
				)
			)
			(howManyTimes
				(if (== cycleDir 1)
					(= cycleDir -1)
				else
					(= cycleDir 1)
				)
				(-= howManyTimes 1)
			)
			(else
				(= completed 1)
				(self motionCue:)
			)
		)
	)
)

