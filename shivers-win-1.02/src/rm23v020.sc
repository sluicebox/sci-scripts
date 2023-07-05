;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23020)
(include sci.sh)
(use Main)

(public
	rm23v020 0
)

(instance rm23v020 of ShiversRoom
	(properties
		picture 23020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23010
	)
)

