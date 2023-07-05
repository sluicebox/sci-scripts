;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29240)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v240 0
)

(instance rm29v240 of ShiversRoom
	(properties
		picture 29242
	)

	(method (init)
		(if (IsFlag 61)
			(self picture: 29240)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29250
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

