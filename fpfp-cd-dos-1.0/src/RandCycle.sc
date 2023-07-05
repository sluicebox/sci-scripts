;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 941)
(include sci.sh)
(use Main)
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
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)
)

(class TalkRandCycle of RandCycle
	(properties)

	(method (doit &tmp temp0 [temp1 40])
		(if (or (> count (= temp0 (GetTime))) (== count -1))
			(if (> (- temp0 cycleCnt) (client cycleSpeed:))
				(cond
					((DoAudio 12)
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

(class RTRandCycle of RandCycle
	(properties)
)

