;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39070)
(include sci.sh)
(use Main)

(public
	rm39v070 0
)

(instance rm39v070 of ShiversRoom
	(properties
		picture 39070
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 39040) ; rm39v040
			(gSounds fade: 23901 66 5 16 0 0)
			(gSounds fade: 23902 42 5 16 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39060
	)
)

(instance efForward of ExitFeature ; UNUSED
	(properties
		nextRoom 39110
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

