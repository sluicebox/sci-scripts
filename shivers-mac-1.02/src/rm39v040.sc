;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm39v040 0
)

(instance rm39v040 of ShiversRoom
	(properties
		picture 39040
	)

	(method (init)
		(if (IsFlag 43)
			(gSounds play: 13911 0 82 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39030
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 39070
	)

	(method (init)
		(self createPoly: 204 143 174 124 173 79 136 78 27 76 26 106 62 144)
		(super init: &rest)
	)
)

