;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3050)
(include sci.sh)
(use Main)

(public
	rm3v050 0
)

(instance rm3v050 of ShiversRoom
	(properties
		picture 3050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3040
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 3010
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

