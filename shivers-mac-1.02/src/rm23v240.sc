;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23240)
(include sci.sh)
(use Main)

(public
	rm23v240 0
)

(instance rm23v240 of ShiversRoom
	(properties
		picture 23240
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23230
	)
)

