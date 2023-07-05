;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm7v020 0
)

(instance rm7v020 of ShiversRoom
	(properties
		picture 7020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 43)
			(gSounds play: 10712 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7300
	)
)

