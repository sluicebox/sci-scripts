;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 751)
(include sci.sh)
(use Main)
(use Motion)

(class RandCycle of Cycle
	(properties
		count -1
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(if (>= argc 2)
			(= count param2)
			(if (>= argc 3)
				(= caller param3)
			)
		else
			(= count -1)
		)
	)

	(method (doit)
		(++ cycleCnt)
		(if (> cycleCnt (client cycleSpeed:))
			(if count
				(if (> count 0)
					(-- count)
				)
				(client cel: (self nextCel:))
				(= cycleCnt 0)
			else
				(self cycleDone:)
			)
		)
	)

	(method (nextCel &tmp temp0)
		(while (== (= temp0 (Random 0 (client lastCel:))) (client cel:))
		)
		(return temp0)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= global58 1)
		else
			(self motionCue:)
		)
	)
)

