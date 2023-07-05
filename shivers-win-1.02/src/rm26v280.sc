;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26280)
(include sci.sh)
(use Main)

(public
	rm26v280 0
)

(instance rm26v280 of ShiversRoom
	(properties
		picture 26280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26240
	)

	(method (init)
		(self createPoly: 57 145 72 129 72 45 178 45 178 126 196 146)
		(super init: &rest)
	)
)

