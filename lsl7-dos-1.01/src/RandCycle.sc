;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64941)
(include sci.sh)
(use Motion)

(class RandCycle of Cycle
	(properties
		count -1
		reset 0
	)

	(method (init obj theTime whoCares resetTo0)
		(super init: obj)
		(if (>= argc 4)
			(= reset resetTo0)
		)
		(if reset
			(client cel: 0)
		)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(if (!= theTime -1)
				(= count (+ (GetTime) theTime))
			else
				(= count -1)
			)
			(if (>= argc 3)
				(= caller whoCares)
			)
		else
			(= count -1)
		)
	)

	(method (doit &tmp theTime)
		(if (or (> count (= theTime (GetTime))) (== count -1))
			(if (> (- theTime cycleCnt) (client cycleSpeed:))
				(client cel: (self nextCel:))
				(= cycleCnt (GetTime))
			)
		else
			(if reset
				(client cel: 0)
			)
			(self cycleDone:)
		)
	)

	(method (nextCel &tmp newCel)
		(return
			(if (!= (NumCels client) 1)
				(while (== (= newCel (Random 0 (client lastCel:))) (client cel:))
				)
				newCel
			)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(self motionCue:)
	)
)

(class TalkRandCycle of RandCycle
	(properties)

	(method (doit &tmp temp0 [temp1 40])
		(if (or (> count (= temp0 (GetTime))) (== count -1))
			(if (> (- temp0 cycleCnt) (client cycleSpeed:))
				(cond
					((DoAudio 17) ; AudCheckNoise
						(client cel: (self nextCel:))
						(= cycleCnt (GetTime))
					)
					((!= (client cel:) 0)
						(client cel: 0)
					)
				)
			)
		else
			(if reset
				(client cel: 0)
			)
			(self cycleDone:)
		)
	)
)

(class RangeRandCycle of RandCycle
	(properties
		nFirstCel 0
		nLastCel 0
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(super init: param1)
		(if (>= argc 6)
			(= reset param6)
		)
		(if reset
			(client cel: 0)
		)
		(cond
			((< argc 3)
				(= nFirstCel 0)
				(= nLastCel (client param4:))
			)
			((== argc 3)
				(= nFirstCel param3)
				(= nLastCel (client param4:))
			)
			(else
				(= nFirstCel param3)
				(= nLastCel param4)
			)
		)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(if (!= param2 -1)
				(= count (+ (GetTime) param2))
			else
				(= count -1)
			)
			(if (>= argc 5)
				(= caller param5)
			)
		else
			(= count -1)
		)
	)

	(method (nextCel &tmp temp0)
		(return
			(if (!= (NumCels client) 1)
				(while (== (= temp0 (Random nFirstCel nLastCel)) (client cel:))
				)
				temp0
			)
		)
	)
)

(class RTRandCycle of RandCycle
	(properties)
)

