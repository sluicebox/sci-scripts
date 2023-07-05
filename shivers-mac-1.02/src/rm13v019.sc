;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13019)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v019 0
)

(instance rm13v019 of ShiversRoom
	(properties
		picture 13210
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 13020) ; rm13v020
			(gSounds fade: 21302 0 5 16 1 0)
			(proc951_9 21301)
			(gSounds play: 21301 -1 0 0)
			(gSounds fade: 21301 114 10 16 0 0)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13016
	)

	(method (init)
		(self createPoly: 113 90 117 54 153 54 158 90)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13602
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13601
	)
)

