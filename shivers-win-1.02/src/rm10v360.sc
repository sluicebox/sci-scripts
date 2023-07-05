;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10360)
(include sci.sh)
(use Main)

(public
	rm10v360 0
)

(instance rm10v360 of ShiversRoom
	(properties
		picture 10360
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10370
	)

	(method (init)
		(self createPoly: 50 125 70 98 53 15 80 8 149 4 223 11 225 92 244 120)
		(super init: &rest)
	)
)

