;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23100)
(include sci.sh)
(use Main)

(public
	rm23v100 0
)

(instance rm23v100 of ShiversRoom
	(properties
		picture 23100
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
		nextRoom 23110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23190
	)

	(method (init)
		(self createPoly: 94 36 149 36 161 29 161 120 64 122 94 102 94 36)
		(super init: &rest)
	)
)

