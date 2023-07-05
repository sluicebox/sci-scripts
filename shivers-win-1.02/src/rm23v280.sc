;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23280)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v280 0
)

(instance rm23v280 of ShiversRoom
	(properties
		picture 23280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 12311 0 90 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23310
	)
)

