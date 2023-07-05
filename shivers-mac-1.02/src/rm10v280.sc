;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10280)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v280 0
)

(instance rm10v280 of ShiversRoom
	(properties
		picture 10280
	)

	(method (init)
		(if (IsFlag 43)
			(gSounds play: 13911 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10290
	)
)

