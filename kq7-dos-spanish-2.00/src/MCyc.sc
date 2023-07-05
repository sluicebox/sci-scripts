;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64942)
(include sci.sh)
(use Main)
(use Motion)

(class MCyc of Cycle
	(properties
		value 0
		points 0
		size 0
	)

	(method (init who thePoints whoCares whichWay &tmp [temp0 2])
		(= client who)
		(= points thePoints)
		(if (> argc 2)
			(= caller whoCares)
			(if (> argc 3)
				(= cycleDir whichWay)
			)
		)
		(for ((= size 0)) (!= (points at: size) 32768) ((++ size))
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
			loop: (points at: value)
			cel: (points at: (+ value 1))
			x: (points at: (+ value 2))
			y: (points at: (+ value 3))
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
		(self motionCue:)
	)
)

