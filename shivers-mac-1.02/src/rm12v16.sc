;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12160)
(include sci.sh)
(use Main)

(public
	rm12v16 0
)

(instance rm12v16 of ShiversRoom
	(properties
		picture 12160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 100
		nextRoom 12130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12420
	)
)

