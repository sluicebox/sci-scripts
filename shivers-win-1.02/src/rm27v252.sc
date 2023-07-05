;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27252)
(include sci.sh)
(use Main)

(public
	rm27v252 0
)

(instance rm27v252 of ShiversRoom
	(properties
		picture 27252
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27242
	)

	(method (init)
		(self createPoly: 68 142 99 53 126 53 155 142 69 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27251
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27250
	)
)

