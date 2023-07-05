;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13437)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v437 0
)

(instance rm13v437 of ShiversRoom
	(properties
		picture 13220
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 13441) ; rm13v441
			(gSounds fade: 21302 0 5 16 1 0)
			(proc951_9 21301)
			(gSounds play: 21301 -1 0 0)
			(gSounds fade: 21301 114 10 16 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13015
	)

	(method (init)
		(self createPoly: 117 90 117 51 153 51 153 90)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13604
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13603
	)
)

