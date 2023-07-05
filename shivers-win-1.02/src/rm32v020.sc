;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v020 0
)

(instance rm32v020 of ShiversRoom
	(properties
		picture 32020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 43)
			(gSounds play: 13014 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32010
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 32010
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

