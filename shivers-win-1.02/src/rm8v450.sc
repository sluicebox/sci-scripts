;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8450)
(include sci.sh)
(use Main)

(public
	rm8v450 0
)

(instance rm8v450 of ShiversRoom
	(properties
		picture 8450
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8480
	)
)

