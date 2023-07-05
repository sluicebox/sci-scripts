;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3070)
(include sci.sh)
(use Main)

(public
	rm3v070 0
)

(instance rm3v070 of ShiversRoom
	(properties
		picture 3070
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3100
	)

	(method (init)
		(self createPoly: 74 131 18 119 52 114 108 122 109 124)
		(super init: &rest)
	)
)

