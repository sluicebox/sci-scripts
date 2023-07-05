;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32570)
(include sci.sh)
(use Main)

(public
	rm32v570 0
)

(instance rm32v570 of ShiversRoom
	(properties
		picture 32570
		invView 1
	)

	(method (init)
		(self initRoom: 96 147 69 126)
		(psOnBlock init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance psOnBlock of PotSpot
	(properties
		nsLeft 96
		nsTop 69
		nsRight 147
		nsBottom 126
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32580
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32580
	)

	(method (init)
		(self createPoly: 220 0 263 0 263 144 220 144 220 0)
		(super init: &rest)
	)
)

