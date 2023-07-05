;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1211)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v211 0
)

(instance rm1v211 of ShiversRoom
	(properties
		picture 1211
	)

	(method (init)
		(if (IsFlag 1)
			(vStonehengeOpen init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitSymbol init: 3)
		(super init: &rest)
	)
)

(instance vStonehengeOpen of View
	(properties
		priority 20
		fixPriority 1
		view 1212
	)
)

(instance efExitSymbol of ExitFeature
	(properties
		nextRoom 1213
	)

	(method (init)
		(self createPoly: 216 36 216 61 192 61 192 36)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1202
	)
)

