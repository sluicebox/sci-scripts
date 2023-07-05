;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v060 0
)

(instance rm9v060 of ShiversRoom
	(properties
		picture 9060
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 10918 0 40 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efPlaque init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9140
	)

	(method (init)
		(self createPoly: 216 147 138 139 143 74 178 51 208 44)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 9100
	)

	(method (init)
		(self createPoly: 51 140 47 105 39 105 21 115 21 144)
		(super init: &rest)
	)
)

