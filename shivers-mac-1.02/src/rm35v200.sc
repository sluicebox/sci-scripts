;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35200)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm35v200 0
)

(instance rm35v200 of ShiversRoom
	(properties
		picture 35200
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
		(efExitDown init: 5)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (and (!= [global118 45] 0) (== global546 530))
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
		view 35200
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
		view 35200
		loop 1
	)
)

(instance vPotView of View
	(properties
		x 117
		y 106
		view 0
	)

	(method (init)
		(self view: [global118 45] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 25)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 35401
	)

	(method (init)
		(self createPoly: 64 143 64 123 175 123 175 143 64 143)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35110
	)

	(method (init)
		(self createPoly: 68 49 68 121 205 121 205 48 68 48)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35230
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35270
	)
)

