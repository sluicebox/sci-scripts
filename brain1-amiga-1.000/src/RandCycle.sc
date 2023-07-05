;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 941)
(include sci.sh)
(use Main)
(use Motion)

(class RandCycle of Cycle
	(properties
		count -1
	)

	(method (init theObj num whoCares)
		(super init: theObj)
		(if (>= argc 2)
			(= count num)
			(if (>= argc 3)
				(= caller whoCares)
			)
		else
			(= count -1)
		)
	)

	(method (doit)
		(if (>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(if count
				(if (> count 0)
					(-- count)
				)
				(client cel: (self nextCel:))
				(= cycleCnt gGameTime)
			else
				(self cycleDone:)
			)
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

