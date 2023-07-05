;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm18v17 0
)

(instance rm18v17 of ShiversRoom
	(properties
		picture 18170
	)

	(method (init)
		(efExitJustLeft init: 2)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(if (IsFlag 43)
			(ClearFlag 43)
			(gSounds play: 11806 0 82 0)
		)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18150
	)

	(method (init)
		(self createPoly: 1 1 40 1 40 142 1 142 1 1)
		(super init: &rest)
	)
)

(instance efExitJustLeft of ExitFeature
	(properties
		nextRoom 18180
	)

	(method (init)
		(self createPoly: 41 1 111 1 111 142 41 142 41 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18240
	)

	(method (init)
		(self createPoly: 186 1 262 1 262 142 186 142 186 1)
		(super init: &rest)
	)
)

