;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12310)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v31 0
)

(instance rm12v31 of ShiversRoom
	(properties
		picture 12310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 10)
			((View new:) view: 12310 cel: 0 setPri: 10 1 init:)
			(if (!= [global118 15] 0)
				(vPotView init:)
				(vMask init:)
			)
		)
		(if (IsFlag 9)
			((View new:) view: 12310 cel: 1 setPri: 10 1 init:)
		)
		(super init: &rest)
	)
)

(instance vMask of View
	(properties
		priority 30
		fixPriority 1
		view 12310
		loop 1
	)
)

(instance vPotView of View
	(properties
		x 133
		y 110
		view 0
	)

	(method (init)
		(self view: [global118 15] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 8 scaleY: 8 setPri: 20)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12180
	)

	(method (init)
		(self
			createPoly:
				39
				143
				99
				89
				101
				70
				142
				69
				142
				75
				136
				82
				135
				92
				162
				98
				222
				148
		)
		(super init: &rest)
	)
)

