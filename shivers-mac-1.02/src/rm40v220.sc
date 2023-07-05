;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40220)
(include sci.sh)
(use Main)

(public
	rm40v220 0
)

(instance rm40v220 of ShiversRoom
	(properties
		picture 40330
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40240
	)

	(method (init)
		(self createPoly: 79 142 240 142 220 116 179 93 144 1 77 1 79 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40230
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40230
	)
)

