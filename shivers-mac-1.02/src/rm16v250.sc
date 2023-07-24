;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v250 0
)

(instance rm16v250 of ShiversRoom
	(properties
		picture 16250
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16254)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16270
	)

	(method (init)
		(self
			createPoly: 29 145 87 31 165 32 175 43 175 75 150 79 146 72 131 71 131 84 135 87 162 84 233 82 233 90 172 95 157 106 157 132 170 146
		)
		(super init: &rest)
	)
)

