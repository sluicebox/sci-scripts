;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17170)
(include sci.sh)
(use Main)

(public
	rm17v170 0
)

(instance rm17v170 of ShiversRoom
	(properties
		picture 17170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17130
	)
)

