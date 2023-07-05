;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31410)
(include sci.sh)
(use Main)

(public
	rm31v410 0
)

(instance rm31v410 of ShiversRoom
	(properties
		picture 31410
	)

	(method (init)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 31130
	)

	(method (init)
		(self createPoly: 41 32 125 32 125 109 41 109 41 32)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 31411
	)

	(method (init)
		(self createPoly: 142 17 142 106 219 106 219 17 142 17)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31140
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31200
	)
)

