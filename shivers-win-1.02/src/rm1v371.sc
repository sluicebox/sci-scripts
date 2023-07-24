;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1371)
(include sci.sh)
(use Main)

(public
	rm1v371 0
)

(instance rm1v371 of ShiversRoom
	(properties
		picture 1371
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1373
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1372
	)

	(method (init)
		(self createPoly: 264 0 215 0 215 124 223 124 223 142 264 142 264 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1394
	)

	(method (init)
		(self
			createPoly: 82 4 160 4 160 23 170 23 209 124 209 133 30 132 82 22 82 4
		)
		(super init: &rest)
	)
)

