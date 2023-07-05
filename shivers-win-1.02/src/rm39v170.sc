;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39170)
(include sci.sh)
(use Main)

(public
	rm39v170 0
)

(instance rm39v170 of ShiversRoom
	(properties
		picture 39170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPipes init: 3)
		(if (== gPrevRoomNum 39090) ; rm39v090
			(gSounds fade: 23901 50 5 16 0 0)
			(gSounds fade: 23902 58 5 16 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39120
	)
)

(instance efExitPipes of ExitFeature
	(properties
		nextRoom 39060
	)

	(method (init)
		(self createPoly: 180 94 186 98 186 122 240 122 240 79 180 79 180 94)
		(super init: &rest)
	)
)

