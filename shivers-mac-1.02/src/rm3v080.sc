;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3080)
(include sci.sh)
(use Main)

(public
	rm3v080 0
)

(instance rm3v080 of ShiversRoom
	(properties
		picture 3080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3100
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 3100
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

