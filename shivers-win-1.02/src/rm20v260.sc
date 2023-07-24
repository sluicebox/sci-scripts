;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20260)
(include sci.sh)
(use Main)

(public
	rm20v260 0
)

(instance rm20v260 of ShiversRoom
	(properties
		picture 20261
	)

	(method (init)
		(efExitBack init: 8)
		(efExitNecklace init: 3)
		(super init: &rest)
		(if (== gPrevRoomNum 20261) ; rm20v261
			(gSounds play: 12022 0 82 0)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20220
	)

	(method (init)
		(self
			createPoly: 2 2 2 141 259 141 259 2 2 2 39 37 39 109 210 109 210 37 40 37
		)
		(super init: &rest)
	)
)

(instance efExitNecklace of ExitFeature
	(properties
		nextRoom 20261
	)

	(method (init)
		(self createPoly: 147 90 50 96 29 69 84 62 162 71)
		(super init: &rest)
	)
)

