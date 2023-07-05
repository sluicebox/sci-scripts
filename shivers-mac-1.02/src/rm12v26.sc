;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12260)
(include sci.sh)
(use Main)

(public
	rm12v26 0
)

(instance rm12v26 of ShiversRoom
	(properties
		picture 12260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12270
	)
)

