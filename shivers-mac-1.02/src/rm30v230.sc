;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30230)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v230 0
)

(instance rm30v230 of ShiversRoom
	(properties
		picture 30230
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(if (<= 20000 gPrevRoomNum 30000)
			(proc951_7 23001)
			(proc951_9 23001)
			(gSounds play: 23001 -1 82 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30210
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

