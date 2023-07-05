;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1380)
(include sci.sh)
(use Main)

(public
	rm1v380 0
)

(instance rm1v380 of ShiversRoom
	(properties
		picture 1380
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
		nextRoom 1382
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1383
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1371
	)

	(method (init)
		(self createPoly: 3 131 87 116 105 71 172 75 184 119 257 141 0 143)
		(super init: &rest)
	)
)

