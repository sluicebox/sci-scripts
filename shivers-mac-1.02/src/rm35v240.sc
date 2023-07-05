;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35240)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm35v240 0
)

(instance rm35v240 of ShiversRoom
	(properties
		picture 35240
	)

	(method (init)
		(switch global546
			(530
				(vMask init:)
				(vHead init: 0)
			)
			(1015
				(vHead init: 1)
			)
			(315
				(vHead init: 2)
			)
			(else
				(vHead init: 3)
			)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (and (== global546 530) (!= [global118 45] 0))
			(vPotView init:)
		)
		(super init: &rest)
	)
)

(instance vHead of View
	(properties
		y 143
		priority 10
		fixPriority 1
		view 35240
	)

	(method (init param1)
		(self cel: param1)
		(super init:)
	)
)

(instance vMask of View
	(properties
		y 143
		priority 30
		fixPriority 1
		view 35240
		loop 1
	)
)

(instance vPotView of View
	(properties
		x 118
		y 99
		view 0
	)

	(method (init)
		(self view: [global118 45] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 20)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35110
	)

	(method (init)
		(self createPoly: 64 111 202 131 202 18 66 40 64 111)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35180
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35210
	)
)

