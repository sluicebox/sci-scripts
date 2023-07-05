;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23340)
(include sci.sh)
(use Main)

(public
	rm23v340 0
)

(instance rm23v340 of ShiversRoom
	(properties
		picture 23340
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23320
	)
)

