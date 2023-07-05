;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19120)
(include sci.sh)
(use Main)

(public
	rm19v120 0
)

(instance rm19v120 of ShiversRoom
	(properties
		picture 19120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 40
		nextRoom 19110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 223
		nextRoom 19090
	)
)

