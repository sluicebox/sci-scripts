;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19290)
(include sci.sh)
(use Main)

(public
	rm19v290 0
)

(instance rm19v290 of ShiversRoom
	(properties
		picture 19290
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForwardLeft init: 3)
		(efForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19300
	)
)

(instance efForwardLeft of ExitFeature
	(properties
		nextRoom 19130
	)

	(method (init)
		(self createPoly: 39 130 87 104 76 34 21 34 21 131)
		(super init: &rest)
	)
)

(instance efForwardRight of ExitFeature
	(properties
		nextRoom 19010
	)

	(method (init)
		(self createPoly: 229 132 200 115 178 104 181 35 243 35 243 132)
		(super init: &rest)
	)
)

