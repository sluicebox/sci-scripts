;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30140)
(include sci.sh)
(use Main)

(public
	rm30v140 0
)

(instance rm30v140 of ShiversRoom
	(properties
		picture 30140
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30100
	)

	(method (init)
		(self createPoly: 69 139 91 109 91 47 175 47 175 109 186 139 69 139)
		(super init: &rest)
	)
)

