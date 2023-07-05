;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18120)
(include sci.sh)
(use Main)

(public
	rm18v12 0
)

(instance rm18v12 of ShiversRoom
	(properties
		picture 18120
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
		nextRoom 18110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18140
	)

	(method (init)
		(self createPoly: 53 142 86 112 86 51 185 51 185 116 213 142)
		(super init: &rest)
	)
)

