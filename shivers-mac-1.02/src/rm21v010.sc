;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21010)
(include sci.sh)
(use Main)

(public
	rm21v010 0
)

(instance rm21v010 of ShiversRoom
	(properties
		picture 21010
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
		nextRoom 21020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21030
	)

	(method (init)
		(self createPoly: 77 143 77 22 186 22 186 143)
		(super init: &rest)
	)
)

