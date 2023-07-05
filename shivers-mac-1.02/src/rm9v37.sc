;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9370)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v37 0
)

(instance rm9v37 of ShiversRoom
	(properties
		picture 9370
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (and (IsFlag 42) (== gPrevRoomNum 9710)) ; rm9v710
			(gSounds fade: 10908 26 15 8 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9340
	)
)

