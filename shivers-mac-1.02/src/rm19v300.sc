;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19300)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm19v300 0
)

(instance rm19v300 of ShiversRoom
	(properties
		picture 19300
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if (!= [global118 21] 0)
			(vPotView init:)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19310
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19220
	)

	(method (init)
		(self
			createPoly: 68 143 87 122 86 24 101 10 129 5 156 8 170 24 170 113 180 142
		)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 110
		y 62
		view 0
	)

	(method (init)
		(self view: [global118 21] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 10)
	)
)

