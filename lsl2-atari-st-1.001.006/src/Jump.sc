;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 991)
(include sci.sh)
(use System)

(class Jump of Obj
	(properties
		gx 0
		gy 3
		xStep 20000
		yStep 0
		client 0
		caller 0
		x 20000
		y 20000
		signal 0
		illegalBits 0
		waitApogeeX 1
		waitApogeeY 1
		dx 0
		dy 0
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
		(self setTest: doit:)
	)

	(method (doit &tmp lxs lys)
		(client x: (+ (client x:) xStep) y: (+ (client y:) yStep))
		(= lxs xStep)
		(= lys yStep)
		(+= xStep gx)
		(+= yStep gy)
		(if (and (not waitApogeeX) (!= x 20000) (<= 0 (* dx (- (client x:) x))))
			(client x: x)
			(self moveDone:)
			(return)
		)
		(if (and (not waitApogeeY) (!= y 20000) (<= 0 (* dy (- (client y:) y))))
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

	(method (triedToMove)
		(return 1)
	)

	(method (moveDone)
		(client mover: 0 illegalBits: illegalBits signal: signal)
		(if caller
			(caller cue:)
		)
		(self dispose:)
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
		(client x: x y: y)
		(super moveDone:)
	)
)

