;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27040)
(include sci.sh)
(use Main)

(public
	rm27v040 0
)

(instance rm27v040 of ShiversRoom
	(properties
		picture 27040
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
		nextRoom 27050
	)

	(method (init)
		(self createPoly: 91 142 122 58 142 58 180 142 91 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27043
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27041
	)
)

