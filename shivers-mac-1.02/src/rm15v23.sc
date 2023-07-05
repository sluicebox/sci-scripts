;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15230)
(include sci.sh)
(use Main)
(use n951)

(public
	rm15v23 0
)

(instance rm15v23 of ShiversRoom
	(properties
		picture 15230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 43)
			(gSounds play: 11503 0 98 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15200
	)

	(method (init)
		(self createPoly: 80 142 80 25 228 25 228 142)
		(super init: &rest)
	)
)

