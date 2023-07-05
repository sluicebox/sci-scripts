;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7040)
(include sci.sh)
(use Main)

(public
	rm7v041 0
)

(instance rm7v041 of ShiversRoom
	(properties
		picture 7040
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7050
	)
)

