;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16370)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm16v370 0
)

(instance rm16v370 of ShiversRoom
	(properties
		picture 16370
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16374)
			(if (!= [global118 19] 0)
				(vPotView init:)
			)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 126
		y 108
		view 0
	)

	(method (init)
		(self view: [global118 19] loop: 2)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 15)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16430
	)

	(method (init)
		(if (IsFlag 13)
			(self createPoly: 101 142 101 87 85 77 83 25 130 26 155 14 155 142)
		else
			(self createPoly: 100 142 100 84 85 77 85 40 112 40 112 102 136 146)
		)
		(super init: &rest)
	)
)

