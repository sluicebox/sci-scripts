;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1280)
(include sci.sh)
(use Main)

(public
	rm1v280 0
)

(instance rm1v280 of ShiversRoom
	(properties
		picture 1280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1281
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1282
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1271
	)

	(method (init)
		(self createPoly: 26 129 70 127 120 47 192 50 208 130 243 141 16 142)
		(super init: &rest)
	)
)

