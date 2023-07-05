;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20200)
(include sci.sh)
(use Main)

(public
	rm20v200 0
)

(instance rm20v200 of ShiversRoom
	(properties
		picture 20200
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
		nextRoom 20110
	)

	(method (init)
		(self createPoly: 44 24 208 24 208 133 41 133 41 24 44 24)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20220
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20220
	)
)

