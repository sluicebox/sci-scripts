;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16010)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v10 0
)

(instance rm16v10 of ShiversRoom
	(properties
		picture 16010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 43)
			(gSounds play: 11602 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16000
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16110
	)

	(method (init)
		(self createPoly: 19 144 94 103 94 45 151 45 151 99 204 142)
		(super init: &rest)
	)
)

