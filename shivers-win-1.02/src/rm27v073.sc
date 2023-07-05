;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27073)
(include sci.sh)
(use Main)

(public
	rm27v073 0
)

(instance rm27v073 of ShiversRoom
	(properties
		picture 27073
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27103
	)

	(method (init)
		(self createPoly: 85 142 108 48 141 48 170 142 85 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27072
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27070
	)
)

