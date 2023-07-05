;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31411)
(include sci.sh)
(use Main)

(public
	rm31v411 0
)

(instance rm31v411 of ShiversRoom
	(properties
		picture 31411
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForwardRight init: 3)
		(efExitForwardLeft init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31520
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31520
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 31130
	)

	(method (init)
		(self createPoly: 38 14 98 14 98 115 38 115 38 14)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 31510
	)

	(method (init)
		(self createPoly: 109 10 109 129 230 129 230 11 110 11)
		(super init: &rest)
	)
)

