;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 809)
(include sci.sh)
(use Main)
(use PolyPath)
(use Sound)
(use Motion)
(use User)
(use System)

(local
	[local0 18] = [359 338 22 0 67 23 112 68 157 113 202 158 247 203 292 248 337 293]
	[local18 18] = [0 -1 0 -1 1 -1 1 0 1 1 0 1 -1 1 -1 0 -1 -1]
)

(class Inertia of Code
	(properties
		client 0
		inertia 0
		maxInertia 0
		oldDir 0
		oldSpeed 0
		oldMover 0
		swimCnt 0
		xOff 0
		yOff 0
		inertizing 0
	)

	(method (init param1)
		(if argc
			(= client param1)
		else
			(= client gEgo)
		)
		(= xOff (= yOff (= inertia (= swimCnt (= inertizing (= oldMover 0))))))
		(= oldDir (client heading:))
		(if (client mover:)
			(= oldMover (client mover:))
		)
		(if (== client gEgo)
			(client setScript: inertiaScript)
		)
		(client code: self)
	)

	(method (dispose)
		(client moveSpeed: oldSpeed code: 0)
		(if (== client gEgo)
			(client setScript: 0)
		)
		(= client 0)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			((client isBlocked:)
				(self moveDone:)
			)
			(inertizing
				(cond
					((and (== (client heading:) oldDir) (client mover:))
						(self moveDone:)
					)
					((> swimCnt 0)
						(self doMove:)
						(-- swimCnt)
					)
					((> inertia 0)
						(self doMove:)
						(-- inertia)
						(= swimCnt inertia)
					)
					(else
						(self moveDone:)
					)
				)
			)
			(
				(and
					(< inertia maxInertia)
					(>= (++ swimCnt) (client moveSpeed:))
					(client mover:)
				)
				(= oldMover (client mover:))
				(= swimCnt 0)
				(++ inertia)
			)
			(
				(or
					(!= (client heading:) oldDir)
					(and (not (client mover:)) oldMover)
				)
				(for ((= temp0 0)) (< temp0 17) ((+= temp0 2))
					(if (>= [local0 temp0] oldDir [local0 (+ temp0 1)])
						(= xOff [local18 temp0])
						(= yOff [local18 (+ temp0 1)])
						(= temp0 17)
					)
				)
				(= inertizing 1)
				(= swimCnt inertia)
				(= oldSpeed (client moveSpeed:))
				(self doMove:)
			)
		)
	)

	(method (doMove)
		(client
			moveSpeed: inertia
			x: (+ (client x:) (* (client xStep:) xOff))
			y: (+ (client y:) (* (client yStep:) yOff))
		)
	)

	(method (moveDone)
		(client moveSpeed: oldSpeed)
		(= oldDir (client heading:))
		(= xOff (= yOff (= inertia (= swimCnt (= inertizing (= oldMover 0))))))
	)
)

(class Swim of Fwd
	(properties)

	(method (doit)
		(if (and (client mover:) (not (client isBlocked:)))
			(super doit:)
		)
	)
)

(instance InertTo of Motion
	(properties)

	(method (onTarget)
		(return
			(and
				(>= (+ x 10) (client x:) (- x 10))
				(>= (+ y 10) (client y:) (- y 10))
			)
		)
	)

	(method (doit &tmp temp0)
		(if (self onTarget:)
			(self moveDone:)
		else
			(if (!= (client heading:) (GetAngle (client x:) (client y:) x y))
				(InitBresen self)
			)
			(super doit:)
		)
	)
)

(instance inertiaScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(jetSound dispose:)
		(super dispose: &rest)
		(gDirectionHandler delete: self)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(not (User controls:))
					(!= (event type:) evVERB)
					(event modifiers:)
				)
				(if (& (event type:) $0040) ; direction
					(jetSound number: 502 loop: 1 play:)
				)
				(super handleEvent: event)
			)
			(else
				(client
					setMotion:
						(if gUseObstacles PolyPath else InertTo)
						(event x:)
						(event y:)
				)
				(jetSound number: 502 loop: 1 play:)
				(User prevDir: 0)
				(event claimed: 1)
			)
		)
	)
)

(instance jetSound of Sound
	(properties)
)

