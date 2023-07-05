;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26240)
(include sci.sh)
(use Main)

(public
	rm26v240 0
)

(instance rm26v240 of ShiversRoom
	(properties
		picture 26240
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
		nextRoom 26270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26220
	)

	(method (init)
		(self createPoly: 60 143 59 36 199 36 200 143)
		(super init: &rest)
	)
)

