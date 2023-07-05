;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9280)
(include sci.sh)
(use Main)

(public
	rm9v28 0
)

(instance rm9v28 of ShiversRoom
	(properties
		picture 9280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9270
	)
)

