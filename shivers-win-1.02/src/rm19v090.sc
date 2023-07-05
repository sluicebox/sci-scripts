;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19090)
(include sci.sh)
(use Main)

(public
	rm19v090 0
)

(instance rm19v090 of ShiversRoom
	(properties
		picture 19090
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
		nextRoom 19120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19100
	)
)

