;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27122)
(include sci.sh)
(use Main)

(public
	rm27v122 0
)

(instance rm27v122 of ShiversRoom
	(properties
		picture 27122
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
		nextRoom 27111
	)

	(method (init)
		(self createPoly: 57 142 110 54 151 54 189 142 57 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27121
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27123
	)
)

