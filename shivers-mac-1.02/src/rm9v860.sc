;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9860)
(include sci.sh)
(use Main)

(public
	rm9v860 0
)

(instance rm9v860 of ShiversRoom
	(properties
		picture 9860
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9380
	)
)

