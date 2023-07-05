;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35110)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm35v110 0
)

(instance rm35v110 of ShiversRoom
	(properties
		picture 35110
		invView 1
	)

	(method (init)
		(switch global546
			(530
				(self initRoom: 98 118 87 109)
				(inMouth init:)
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
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance inMouth of PotSpot
	(properties
		nsLeft 98
		nsTop 87
		nsRight 118
		nsBottom 109
	)
)

(instance vHead of View
	(properties
		y 143
		priority 10
		fixPriority 1
		view 35110
	)

	(method (init param1)
		(self cel: param1)
		(super init:)
	)
)

(instance vMask of View
	(properties
		priority 30
		fixPriority 1
		view 35110
		loop 1
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35280
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35290
	)
)

