;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11190)
(include sci.sh)
(use Main)

(public
	rm11v190 0
)

(instance rm11v190 of ShiversRoom
	(properties
		picture 11190
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForwardLeft init: 9)
		(efForwardRight init: 9)
		(efInhaler init: 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11600
	)
)

(instance efForwardLeft of ExitFeature
	(properties
		nextRoom 11150
	)

	(method (init)
		(self createPoly: 96 122 44 122 44 87 35 77 35 48 96 48 96 121)
		(super init: &rest)
	)
)

(instance efForwardRight of ExitFeature
	(properties
		nextRoom 11050
	)

	(method (init)
		(self
			createPoly: 169 143 169 107 168 77 164 76 163 55 211 55 211 99 243 117 243 144
		)
		(super init: &rest)
	)
)

(instance efInhaler of ExitFeature
	(properties
		nextRoom 11510
	)

	(method (init)
		(self createPoly: 48 136 59 124 84 124 83 137)
		(super init: &rest)
	)
)

