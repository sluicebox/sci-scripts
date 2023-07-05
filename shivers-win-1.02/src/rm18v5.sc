;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18050)
(include sci.sh)
(use Main)

(public
	rm18v5 0
)

(instance rm18v5 of ShiversRoom
	(properties
		picture 18050
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18020
	)

	(method (init)
		(self createPoly: 90 142 93 138 93 44 180 44 183 51 185 57 185 143)
		(super init: &rest)
	)
)

