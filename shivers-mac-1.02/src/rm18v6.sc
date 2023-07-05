;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18060)
(include sci.sh)
(use Main)

(public
	rm18v6 0
)

(instance rm18v6 of ShiversRoom
	(properties
		picture 18060
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
		nextRoom 18050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18090
	)

	(method (init)
		(self createPoly: 41 143 41 34 180 34 188 61 190 92 188 142)
		(super init: &rest)
	)
)

