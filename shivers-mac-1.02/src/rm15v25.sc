;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm15v25 0
)

(instance rm15v25 of ShiversRoom
	(properties
		picture 15250
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 43)
			(gSounds play: 11503 0 98 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 203
		nextRoom 15260
	)
)

