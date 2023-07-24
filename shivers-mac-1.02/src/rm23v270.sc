;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23270)
(include sci.sh)
(use Main)

(public
	rm23v270 0
)

(instance rm23v270 of ShiversRoom
	(properties
		picture 23270
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23280
	)

	(method (init)
		(self
			createPoly: 198 42 66 42 50 70 50 78 66 119 61 131 219 131 219 105 214 100 214 80 201 72 201 44
		)
		(super init: &rest)
	)
)

