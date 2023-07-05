;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27242)
(include sci.sh)
(use Main)

(public
	rm27v242 0
)

(instance rm27v242 of ShiversRoom
	(properties
		picture 27242
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
		nextRoom 27233
	)

	(method (init)
		(self createPoly: 89 142 112 44 151 44 174 142 89 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27241
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27240
	)
)

