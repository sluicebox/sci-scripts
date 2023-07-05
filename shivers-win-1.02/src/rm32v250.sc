;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32250)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm32v250 0
)

(instance rm32v250 of ShiversRoom
	(properties
		picture 32250
	)

	(method (init)
		(if (IsFlag 81)
			(= picture 32251)
		else
			(= picture 32250)
		)
		(vMask init:)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
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
		view 32250
	)
)

(instance vPotView of View
	(properties
		x 60
		y 130
		view 0
	)

	(method (init)
		(self view: [global118 43] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 34 scaleY: 34 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32260
	)

	(method (init)
		(self createPoly: 112 137 112 37 53 37 53 142 112 142)
		(super init: &rest)
	)
)

