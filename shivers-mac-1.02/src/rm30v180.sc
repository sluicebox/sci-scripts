;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30180)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v180 0
)

(instance rm30v180 of ShiversRoom
	(properties
		picture 30180
	)

	(method (init)
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
		nextRoom 30190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30140
	)

	(method (init)
		(self
			createPoly: 182 130 182 55 86 55 86 112 70 139 193 139 190 135 184 135 182 132
		)
		(super init: &rest)
	)
)

