;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13012)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v012 0
)

(instance rm13v012 of ShiversRoom
	(properties
		picture 13120
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 13010) ; rm13v010
			(proc951_9 21301)
			(gSounds play: 21301 -1 0 0)
			(gSounds fade: 21301 114 10 16 0 0)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13014
	)

	(method (init)
		(self createPoly: 118 86 118 56 145 56 145 86)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13600
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13607
	)
)

