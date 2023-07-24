;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1511)
(include sci.sh)
(use Main)

(public
	rm1v511 0
)

(instance rm1v511 of ShiversRoom
	(properties
		picture 1511
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1510
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1510
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1501
	)

	(method (init)
		(self
			createPoly: 66 69 188 69 182 116 265 136 265 144 0 144 0 140 70 117 66 69
		)
		(super init: &rest)
	)
)

