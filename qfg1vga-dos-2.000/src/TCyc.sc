;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 419)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class TCyc of Cycle
	(properties
		value 0
		points 0
		size 0
	)

	(method (init param1 param2 param3 param4 &tmp [temp0 2])
		(= client param1)
		(= points param2)
		(if (>= argc 3)
			(cond
				((>= argc 4)
					(= cycleDir param4)
					(= caller param3)
				)
				((IsObject param3)
					(= caller param3)
				)
				(else
					(= cycleDir param3)
				)
			)
		)
		(for ((= size 0)) (!= (WordAt points size) -32768) ((++ size))
		)
		(if (== cycleDir 1)
			(= value 0)
		else
			(= value (- size 2))
		)
		(super init:)
	)

	(method (doit)
		(if (>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(= cycleCnt gGameTime)
			(self nextCel:)
		)
	)

	(method (nextCel)
		(client
			loop: (WordAt points value)
			cel: (WordAt points (+ value 1))
		)
		(+= value (* cycleDir 2))
		(if
			(or
				(and (== cycleDir 1) (>= value size))
				(and (== cycleDir -1) (< value 0))
			)
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(= value 0)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)
)

