;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1393)
(include sci.sh)
(use Main)

(public
	rm1v393 0
)

(instance rm1v393 of ShiversRoom
	(properties
		picture 1400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1392
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1390
	)
)

