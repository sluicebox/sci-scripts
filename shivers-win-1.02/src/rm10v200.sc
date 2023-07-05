;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10200)
(include sci.sh)
(use Main)

(public
	rm10v200 0
)

(instance rm10v200 of ShiversRoom
	(properties
		picture 10200
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitPurse init: 0)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10210
	)
)

(instance efExitPurse of ExitFeature
	(properties
		nextRoom 10202
	)

	(method (init)
		(self createPoly: 110 143 110 133 94 124 69 143 110 143)
		(super init: &rest)
	)
)

