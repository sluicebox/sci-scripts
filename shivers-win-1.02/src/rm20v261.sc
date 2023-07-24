;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20261)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v261 0
)

(instance rm20v261 of ShiversRoom
	(properties
		picture 20262
	)

	(method (init)
		(gSounds stop: 12010)
		(gSounds play: 12010 0 82 0)
		(proc951_16 105)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20260
	)

	(method (init)
		(self
			createPoly: 0 0 30 30 233 30 233 113 30 113 30 30 0 0 262 0 262 144 0 144 0 0
		)
		(super init: &rest)
	)
)

