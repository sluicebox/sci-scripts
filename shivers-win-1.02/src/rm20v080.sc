;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20080)
(include sci.sh)
(use Main)

(public
	rm20v080 0
)

(instance rm20v080 of ShiversRoom
	(properties
		picture 20080
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
		nextRoom 20380
	)

	(method (init)
		(self
			createPoly: 44 119 68 94 69 37 206 37 213 105 227 112 206 127 69 127
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20090
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20070
	)
)

