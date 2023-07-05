;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10010)
(include sci.sh)
(use Main)

(public
	rm10v010 0
)

(instance rm10v010 of ShiversRoom
	(properties
		picture 10010
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10020
	)
)

