;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10380)
(include sci.sh)
(use Main)

(public
	rm10v380 0
)

(instance rm10v380 of ShiversRoom
	(properties
		picture 10380
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitDoor init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10200
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 10410
	)

	(method (init)
		(self createPoly: 126 60 179 43 182 118 119 116 126 60)
		(super init: &rest)
	)
)

