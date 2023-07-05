;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27013)
(include sci.sh)
(use Main)

(public
	rm27v013 0
)

(instance rm27v013 of ShiversRoom
	(properties
		picture 27013
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
		nextRoom 27031
	)

	(method (init)
		(self createPoly: 89 142 126 64 139 64 174 142 90 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27012
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27010
	)
)

