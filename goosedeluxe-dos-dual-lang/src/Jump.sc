;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64991)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class Jump of Motion
	(properties
		x 20000
		y 20000
		gx 0
		gy 3
		xStep 20000
		yStep 0
		signal 0
		illegalBits 0
		waitApogeeX 1
		waitApogeeY 1
	)

	(method (init actor whom &tmp dir)
		(= client actor)
		(if (== argc 2)
			(= caller whom)
		)
		(= illegalBits (client illegalBits:))
		(= signal (client signal:))
		(client illegalBits: 0 setPri:)
		(if (== xStep 20000)
			(= xStep
				(cond
					(
						(or
							(> (= dir (client heading:)) 330)
							(< dir 30)
							(< 150 dir 210)
						)
						0
					)
					((< dir 180)
						(client xStep:)
					)
					(else
						(- (client xStep:))
					)
				)
			)
		)
		(if (not (and waitApogeeX (< (* xStep gx) 0)))
			(= waitApogeeX 0)
		)
		(if (not (and waitApogeeY (< (* yStep gy) 0)))
			(= waitApogeeY 0)
		)
		(= b-moveCnt gGameTime)
		(self setTest:)
	)

	(method (doit &tmp lxs lys)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(= xLast (client x:))
			(= yLast (client y:))
			(client x: (+ xLast xStep) y: (+ yLast yStep))
			(= lxs xStep)
			(= lys yStep)
			(+= xStep gx)
			(+= yStep gy)
			(if
				(and
					(not waitApogeeX)
					(!= x 20000)
					(<= 0 (* dx (- (client x:) x)))
				)
				(client x: x)
				(self moveDone:)
				(return)
			)
			(if
				(and
					(not waitApogeeY)
					(!= y 20000)
					(<= 0 (* dy (- (client y:) y)))
				)
				(client y: y)
				(self moveDone:)
				(return)
			)
			(if (<= (* lxs xStep) 0)
				(= waitApogeeX 0)
				(self setTest:)
			)
			(if (<= (* lys yStep) 0)
				(= waitApogeeY 0)
				(self setTest:)
			)
		)
	)

	(method (moveDone)
		(client illegalBits: illegalBits signal: signal)
		(if caller
			(= completed 1)
			(self motionCue:)
		)
	)

	(method (setTest)
		(= dx
			(if (or (> (client x:) x) (and (== (client x:) x) (> xStep 0)))
				-1
			else
				1
			)
		)
		(= dy
			(if (or (> (client y:) y) (and (== (client y:) y) (> yStep 0)))
				-1
			else
				1
			)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed caller)
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees add: ((Cue new:) cuee: caller yourself:))
		)
		(self dispose:)
	)
)

(class JumpTo of Jump
	(properties)

	(method (init actor xTo yTo toCall &tmp temp0 temp1 [temp2 52])
		(= client actor)
		(= x xTo)
		(= y yTo)
		(if (and (== x (actor x:)) (== y (actor y:)))
			(= illegalBits (client illegalBits:))
			(= signal (client signal:))
			(self moveDone:)
			(return)
		)
		(= temp0 (- x (actor x:)))
		(= temp1 (- y (actor y:)))
		(SetJump self temp0 temp1 gy)
		(if (not temp0)
			(= x 20000)
		)
		(if (not temp1)
			(= y 20000)
		)
		(switch argc
			(3
				(super init: actor)
			)
			(4
				(super init: actor toCall)
			)
		)
	)

	(method (moveDone)
		(if (!= x 20000)
			(client x: x)
		)
		(if (!= y 20000)
			(client y: y)
		)
		(super moveDone:)
	)
)

