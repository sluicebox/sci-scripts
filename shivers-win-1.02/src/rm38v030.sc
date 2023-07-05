;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38030)
(include sci.sh)
(use Main)

(public
	rm38v030 0
)

(instance rm38v030 of ShiversRoom
	(properties
		picture 38030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 38010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 38011
	)
)

