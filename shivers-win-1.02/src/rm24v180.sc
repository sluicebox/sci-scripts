;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24180)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v180 0
)

(instance rm24v180 of ShiversRoom
	(properties
		picture 24180
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (and (not (proc951_11 5 24000)) (== gPrevRoomNum 24010)) ; rm24v010
			(proc951_9 22402)
			(gSounds play: 22402 -1 98 0)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24220
	)

	(method (init)
		(self createPoly: 59 27 59 142 170 128 171 42 60 27)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24190
	)
)

