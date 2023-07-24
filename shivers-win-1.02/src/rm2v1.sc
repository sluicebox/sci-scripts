;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2010)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v1 0
)

(local
	local0
)

(instance rm2v1 of ShiversRoom
	(properties
		picture 2010
	)

	(method (init)
		(gSounds fadeChain:)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(if (not (IsFlag 2))
			(self picture: 2015)
		)
		(efExitForward init: 3)
		(= local0 0)
		(hsEasterEgg init:)
		(super init: &rest)
	)
)

(instance hsEasterEgg of HotSpot
	(properties)

	(method (init)
		(self createPoly: 120 28 121 37 123 42 130 43 136 39 137 28 121 28)
		(super init: &rest)
	)

	(method (doVerb)
		(if (> (++ local0) 1)
			(gSounds play: 35122 0 90 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2000
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2030
	)

	(method (init)
		(self
			createPoly: 51 143 107 77 107 58 121 49 127 55 133 55 141 49 155 58 155 80 212 142
		)
		(super init: &rest)
	)
)

