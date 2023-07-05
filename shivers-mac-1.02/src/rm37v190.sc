;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37190)
(include sci.sh)
(use Main)

(public
	rm37v190 0
)

(instance rm37v190 of ShiversRoom
	(properties
		picture 37190
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37420
	)

	(method (init)
		(self createPoly: 100 133 101 9 166 23 171 119)
		(super init: &rest)
	)
)

