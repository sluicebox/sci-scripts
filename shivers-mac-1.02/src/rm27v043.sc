;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27043)
(include sci.sh)
(use Main)

(public
	rm27v043 0
)

(instance rm27v043 of ShiversRoom
	(properties
		picture 27043
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
		nextRoom 27301
	)

	(method (init)
		(self createPoly: 84 142 118 61 133 61 173 142 84 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27042
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27040
	)
)

