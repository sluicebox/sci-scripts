;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26300)
(include sci.sh)
(use Main)

(public
	rm26v300 0
)

(instance rm26v300 of ShiversRoom
	(properties
		picture 26300
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26310
	)
)

