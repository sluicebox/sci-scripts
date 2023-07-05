;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39060)
(include sci.sh)
(use Main)

(public
	rm39v060 0
)

(instance rm39v060 of ShiversRoom
	(properties
		picture 39060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 39170) ; rm39v170
			(gSounds fade: 23901 66 5 16 0 0)
			(gSounds fade: 23902 42 5 16 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39050
	)
)

(instance efForward of ExitFeature ; UNUSED
	(properties
		nextRoom 39020
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

