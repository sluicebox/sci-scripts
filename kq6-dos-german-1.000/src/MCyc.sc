;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 942)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class MCyc of Cycle
	(properties
		value 0
		points 0
		size 0
	)

	(method (init who thePoints whoCares whichWay &tmp [temp0 2])
		(= client who)
		(= points thePoints)
		(if (>= argc 3)
			(cond
				((>= argc 4)
					(= cycleDir whichWay)
					(= caller whoCares)
				)
				((IsObject whoCares)
					(= caller whoCares)
				)
				(else
					(= cycleDir whoCares)
				)
			)
		)
		(for ((= size 0)) (!= (WordAt points size) -32768) ((++ size))
		)
		(if (== cycleDir 1)
			(= value 0)
		else
			(= value (- size 4))
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
			x: (WordAt points (+ value 2))
			y: (WordAt points (+ value 3))
		)
		(+= value (* cycleDir 4))
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

