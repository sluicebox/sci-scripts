;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23290)
(include sci.sh)
(use Main)

(public
	rm23v290 0
)

(instance rm23v290 of ShiversRoom
	(properties
		picture 23290
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23280
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23360
	)

	(method (init)
		(self createPoly: 167 24 167 134 169 137 85 137 87 133 87 25 166 25)
		(super init: &rest)
	)
)

