;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12320)
(include sci.sh)
(use Main)

(public
	rm12v32 0
)

(instance rm12v32 of ShiversRoom
	(properties
		picture 12320
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12050
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12321
	)
)

