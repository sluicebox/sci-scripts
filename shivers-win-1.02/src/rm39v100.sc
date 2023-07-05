;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39100)
(include sci.sh)
(use Main)

(public
	rm39v100 0
)

(instance rm39v100 of ShiversRoom
	(properties
		picture 39100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 39130) ; rm39v130
			(gSounds fade: 23901 50 5 16 0 0)
			(gSounds fade: 23902 58 5 16 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39170
	)
)

(instance efForward of ExitFeature ; UNUSED
	(properties
		nextRoom 39060
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

