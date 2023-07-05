;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19060)
(include sci.sh)
(use Main)

(public
	rm19v060 0
)

(instance rm19v060 of ShiversRoom
	(properties
		picture 19060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19070
	)
)

