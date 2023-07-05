;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9270)
(include sci.sh)
(use Main)

(public
	rm9v27 0
)

(instance rm9v27 of ShiversRoom
	(properties
		picture 9270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9260
	)
)

