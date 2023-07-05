;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1012)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v12 0
)

(instance rm1v12 of ShiversRoom
	(properties
		picture 1012
	)

	(method (init)
		(if (== gPrevRoomNum 930) ; introMovie
			(proc951_9 10111)
			(gSounds play: 10111 -1 0 0)
			(gSounds fade: 10111 98 1 40 0 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
		(if (IsFlag 43)
			(ClearFlag 43)
			(proc951_9 10128)
			(gSounds play: 10128 0 82 0)
		)
		(if (== gPrevRoomNum 930) ; introMovie
			(= global550 1)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1000
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1010
	)
)

