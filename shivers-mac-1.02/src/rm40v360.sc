;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40360)
(include sci.sh)
(use Main)

(public
	rm40v360 0
)

(instance rm40v360 of ShiversRoom
	(properties
		picture 40180
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40340
	)

	(method (init)
		(self createPoly: 59 126 72 113 112 102 113 3 221 3 221 126 59 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40350
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40350
	)
)

