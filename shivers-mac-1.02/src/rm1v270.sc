;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1270)
(include sci.sh)
(use Main)

(public
	rm1v270 0
)

(instance rm1v270 of ShiversRoom
	(properties
		picture 1270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1271
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1282
	)

	(method (init)
		(self createPoly: 1 1 1 143 125 88 125 1)
		(super init: &rest)
	)
)

