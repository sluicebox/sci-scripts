;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27273)
(include sci.sh)
(use Main)

(public
	rm27v273 0
)

(instance rm27v273 of ShiversRoom
	(properties
		picture 27273
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
		nextRoom 27263
	)

	(method (init)
		(self createPoly: 72 142 94 41 138 41 157 142 72 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27272
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27270
	)
)

