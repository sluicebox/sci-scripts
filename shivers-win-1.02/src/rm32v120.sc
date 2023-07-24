;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32120)
(include sci.sh)
(use Main)

(public
	rm32v120 0
)

(instance rm32v120 of ShiversRoom
	(properties
		picture 32120
	)

	(method (init)
		(efExitCage init: 3)
		(efExitRack init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32130
	)
)

(instance efExitCage of ExitFeature
	(properties
		nextRoom 32610
	)

	(method (init)
		(self createPoly: 37 87 39 10 46 3 60 1 72 3 83 10 84 87 37 87)
		(super init: &rest)
	)
)

(instance efExitRack of ExitFeature
	(properties
		nextRoom 32620
	)

	(method (init)
		(self
			createPoly: 201 119 224 90 224 78 184 75 102 79 102 89 112 119 201 119
		)
		(super init: &rest)
	)
)

