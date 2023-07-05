;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use TargActor)
(use PolyPath)
(use Motion)

(class Elemental of TargActor
	(properties
		following 0
		wandering 0
		igniter 25
		lastWander 0
		newX 0
		newY 0
		attackDist 15
		wanderList 0
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd cue:)
	)

	(method (cue)
		(cond
			(following
				(self follow:)
			)
			(wandering
				(self wander:)
			)
		)
	)

	(method (attack)
		(if (not (gEgo script:))
			(gEgo hurtMe: 0 0)
		)
	)

	(method (follow &tmp chanceLeft theChance xDiff)
		(= xDiff (- x (gEgo x:)))
		(= chanceLeft (* 5 xDiff))
		(if (< (= theChance (Random 1 100)) chanceLeft)
			(= newX (- x (Random 1 (+ 20 xDiff))))
		else
			(= xDiff (Abs xDiff))
			(= newX (+ x (Random 1 (+ 20 xDiff))))
		)
		(cond
			((gEgo script:))
			((< y 105)
				(= newX 160)
				(= newY 70)
			)
			((> y (gEgo y:))
				(= newY (- y 7))
			)
			(else
				(= newY (gEgo y:))
			)
		)
		(self setMotion: PolyPath newX newY self)
	)

	(method (wander &tmp theDir)
		(for
			((= theDir wandering))
			(or (== theDir wandering) (== theDir lastWander))
			((= theDir (Random 1 wanderList)))
		)
		(= lastWander wandering)
		(= wandering theDir)
	)

	(method (ignite)
		(return 0)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			(
				(and
					(< (self distanceTo: gEgo) attackDist)
					(not (gEgo script:))
					(< (gEgo z:) 30)
				)
				(self setMotion: 0)
				(self attack:)
			)
			(following)
			((not (-- igniter))
				(= igniter (Random 15 50))
				(self ignite:)
			)
			((not mover)
				(self wander:)
			)
		)
	)
)

