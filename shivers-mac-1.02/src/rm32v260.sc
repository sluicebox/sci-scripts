;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32260)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm32v260 0
)

(instance rm32v260 of ShiversRoom
	(properties
		picture 32260
	)

	(method (init)
		(vMask init:)
		(efExitForward init: 8)
		(if (!= [global118 43] 0)
			(vPotView init:)
		)
		(super init: &rest)
	)
)

(instance vMask of View
	(properties
		priority 40
		fixPriority 1
		view 32260
	)
)

(instance vPotView of View
	(properties
		x 125
		y 130
		view 0
	)

	(method (init)
		(self view: [global118 43] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 51 scaleY: 51 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 32250
	)
)

(instance efExitRight of ExitFeature ; UNUSED
	(properties
		nextRoom 32250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32250
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

