;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9230)
(include sci.sh)
(use Main)

(public
	rm9v23 0
)

(instance rm9v23 of ShiversRoom
	(properties
		picture 9230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9200
	)
)

