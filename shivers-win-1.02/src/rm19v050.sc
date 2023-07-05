;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19050)
(include sci.sh)
(use Main)

(public
	rm19v050 0
)

(instance rm19v050 of ShiversRoom
	(properties
		picture 19050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19060
	)
)

