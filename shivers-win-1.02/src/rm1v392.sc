;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1392)
(include sci.sh)
(use Main)

(public
	rm1v392 0
)

(instance rm1v392 of ShiversRoom
	(properties
		picture 1392
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1391
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1400
	)

	(method (init)
		(self createPoly: 1 85 42 38 214 40 264 109 263 142 0 143)
		(super init: &rest)
	)
)

