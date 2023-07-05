;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10240)
(include sci.sh)
(use Main)

(public
	rm10v240 0
)

(instance rm10v240 of ShiversRoom
	(properties
		picture 10240
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10250
	)
)

