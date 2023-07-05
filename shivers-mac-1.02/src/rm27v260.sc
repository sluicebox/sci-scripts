;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27260)
(include sci.sh)
(use Main)

(public
	rm27v260 0
)

(instance rm27v260 of ShiversRoom
	(properties
		picture 27260
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
		nextRoom 27230
	)

	(method (init)
		(self createPoly: 94 142 116 47 152 47 183 142 95 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27263
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27261
	)
)

