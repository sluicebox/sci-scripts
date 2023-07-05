;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13434)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v434 0
)

(instance rm13v434 of ShiversRoom
	(properties
		picture 13230
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 13433) ; rm13v433
			(gSounds fade: 21302 0 5 16 1 0)
			(proc951_9 21301)
			(gSounds play: 21301 -1 0 0)
			(gSounds fade: 21301 114 10 16 0 0)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13017
	)

	(method (init)
		(self createPoly: 114 91 114 52 155 52 155 91)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13606
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13605
	)
)

