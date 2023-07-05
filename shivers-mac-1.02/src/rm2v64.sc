;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2640)
(include sci.sh)
(use Main)

(public
	rm2v64 0
)

(instance rm2v64 of ShiversRoom
	(properties
		picture 2470
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2160
	)

	(method (init)
		(self createPoly: 0 0 60 0 60 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2460
	)

	(method (init)
		(self createPoly: 200 0 262 0 262 144 200 144 200 0)
		(super init: &rest)
	)
)

