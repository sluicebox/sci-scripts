;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v200 0
)

(instance rm30v200 of ShiversRoom
	(properties
		picture 30200
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30201)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 43)
			(gSounds play: 13012 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30300
	)

	(method (init)
		(self createPoly: 78 126 78 45 178 45 178 126 78 126)
		(super init: &rest)
	)
)

