;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9310)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v31 0
)

(instance rm9v31 of ShiversRoom
	(properties
		picture 9310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (and (== gPrevRoomNum 9680) (IsFlag 42)) ; rm9v68
			(proc951_7 10908)
			(proc951_9 10908)
			(gSounds play: 10908 -1 8 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9320
	)
)

