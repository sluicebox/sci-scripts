;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30410)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v410 0
)

(instance rm30v410 of ShiversRoom
	(properties
		picture 30410
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30411)
		)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 13008 0 82 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30370
	)

	(method (init)
		(self createPoly: 232 142 231 55 65 55 65 142 231 142)
		(super init: &rest)
	)
)

