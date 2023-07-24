;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1422)
(include sci.sh)
(use Main)

(public
	rm1v422 0
)

(instance rm1v422 of ShiversRoom
	(properties
		picture 1422
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1421
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1423
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1442
	)

	(method (init)
		(self
			createPoly: 0 143 0 129 62 125 59 97 76 92 76 47 157 47 157 92 170 120 238 125 254 141
		)
		(super init: &rest)
	)
)

