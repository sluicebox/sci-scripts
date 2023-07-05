;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9400)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v40 0
)

(instance rm9v40 of ShiversRoom
	(properties
		picture 9400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (and (IsFlag 42) (> gPrevRoomNum 9999))
			(proc951_7 10908)
			(proc951_9 10908)
			(gSounds play: 10908 -1 26 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9340
	)

	(method (init)
		(self createPoly: 32 141 46 123 69 124 101 95 140 94 158 142)
		(super init: &rest)
	)
)

