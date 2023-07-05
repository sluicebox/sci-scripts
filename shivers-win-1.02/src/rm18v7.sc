;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm18v7 0
)

(instance rm18v7 of ShiversRoom
	(properties
		picture 18070
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 11802 0 82 0)
		)
		(ClearFlag 43)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18050
	)

	(method (init)
		(self createPoly: 89 142 117 94 117 47 148 47 148 102 171 142)
		(super init: &rest)
	)
)

