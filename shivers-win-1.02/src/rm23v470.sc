;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23470)
(include sci.sh)
(use Main)

(public
	rm23v470 0
)

(instance rm23v470 of ShiversRoom
	(properties
		picture 23470
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23480
	)
)

