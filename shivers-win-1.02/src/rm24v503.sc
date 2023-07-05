;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24503)
(include sci.sh)
(use Main)

(public
	rm24v503 0
)

(instance rm24v503 of ShiversRoom
	(properties
		picture 24503
	)

	(method (init)
		(efExitLeft init: 0)
		(efExitRight init: 0)
		(if (== gPrevRoomNum 24502) ; rm24v502
			(gSounds play: 12405 0 82 0)
		else
			(gSounds play: 12422 0 82 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24502
	)

	(method (init)
		(self createPoly: 129 6 129 137 6 137 6 5 129 5)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24504
	)

	(method (init)
		(self createPoly: 133 6 133 137 258 137 258 5 133 5)
		(super init: &rest)
	)
)

