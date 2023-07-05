;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12030)
(include sci.sh)
(use Main)

(public
	rm12v03 0
)

(instance rm12v03 of ShiversRoom
	(properties
		picture 12030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12120
	)
)

