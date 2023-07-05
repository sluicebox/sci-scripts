;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Extra)
(use Motion)
(use Actor)

(class Flame of Extra
	(properties
		pauseCel -1
		minPause 1
		maxPause 5
		minCycles 1
		maxCycles 5
	)

	(method (init)
		(|= signal $0200)
		(self description: {a flickering flame} noun: '/flame')
		(super init: &rest)
	)
)

(class Fire of Prop
	(properties
		view 340
		signal 16384
		burnTime 0
	)

	(method (init)
		(super init: &rest)
		(= burnTime (+ (Random 40 75) (* 25 gHowFast)))
		(self loop: 8 cel: 4 cycleSpeed: 1 setCycle: Beg self)
	)

	(method (doit)
		(super doit:)
		(cond
			((< (gEgo distanceTo: self) 5)
				(= burnTime 0)
				(self dispose:)
			)
			((not (-- burnTime))
				(self loop: 8 cel: 0 setCycle: End self)
			)
		)
	)

	(method (cue)
		(super cue:)
		(if (< burnTime 1)
			(self dispose:)
		else
			(self loop: 0 cycleSpeed: 1 setCycle: Fwd)
		)
	)
)

(class FlameSpout of Prop
	(properties
		view 560
		flameTimer 0
	)

	(method (init)
		(self description: {a gaseous jet of flame})
		(super init:)
	)

	(method (doit)
		(if (and flameTimer (not (-- flameTimer)))
			(self setCycle: End self)
		)
		(if (and cel (not (gEgo script:)) (< (gEgo distanceTo: self) 15))
			(self ignite:)
		)
		(super doit:)
	)

	(method (cue)
		(if cel
			(self setCycle: Beg self)
		)
	)

	(method (ignite)
		(return 1)
	)
)

