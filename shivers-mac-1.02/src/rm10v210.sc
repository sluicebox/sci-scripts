;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10210)
(include sci.sh)
(use Main)

(public
	rm10v210 0
)

(instance rm10v210 of ShiversRoom
	(properties
		picture 10210
	)

	(method (init)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10200
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 10220
	)

	(method (init)
		(self createPoly: 23 105 46 52 85 33 126 47 124 105 23 105)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 10380
	)

	(method (init)
		(self createPoly: 132 87 132 1 243 1 242 87 132 87)
		(super init: &rest)
	)
)

