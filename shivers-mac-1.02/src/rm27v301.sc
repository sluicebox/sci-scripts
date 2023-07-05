;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27301)
(include sci.sh)
(use Main)

(public
	rm27v301 0
)

(instance rm27v301 of ShiversRoom
	(properties
		picture 27301
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27292
	)

	(method (init)
		(self createPoly: 86 142 115 50 147 50 173 142 86 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27300
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27300
	)
)

