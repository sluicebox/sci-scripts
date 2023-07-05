;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39190)
(include sci.sh)
(use Main)
(use n951)

(public
	rm39v190 0
)

(instance rm39v190 of ShiversRoom
	(properties
		picture 39190
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 13909 0 82 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39200
	)
)

(instance efForward of ExitFeature ; UNUSED
	(properties
		nextRoom 39260
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

