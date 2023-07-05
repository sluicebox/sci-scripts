;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27232)
(include sci.sh)
(use Main)

(public
	rm27v232 0
)

(instance rm27v232 of ShiversRoom
	(properties
		picture 27232
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
		nextRoom 27262
	)

	(method (init)
		(self createPoly: 84 143 112 47 150 47 171 142 85 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27231
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27233
	)
)

