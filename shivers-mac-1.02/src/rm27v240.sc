;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27240)
(include sci.sh)
(use Main)

(public
	rm27v240 0
)

(instance rm27v240 of ShiversRoom
	(properties
		picture 27240
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27250
	)

	(method (init)
		(self createPoly: 106 142 125 37 174 37 195 143 106 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27242
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27241
	)
)

