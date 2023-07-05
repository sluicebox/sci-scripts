;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13198)
(include sci.sh)
(use Main)

(public
	rm13v198 0
)

(instance rm13v198 of ShiversRoom
	(properties
		picture 13460
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13199
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13194
	)

	(method (init)
		(self createPoly: 41 143 84 128 84 13 186 13 186 127 200 142)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 13194
	)

	(method (init)
		(self createPoly: 39 142 39 0 83 13 83 127)
		(super init: &rest)
	)
)

