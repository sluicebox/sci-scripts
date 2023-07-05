;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27180)
(include sci.sh)
(use Main)

(public
	rm27v180 0
)

(instance rm27v180 of ShiversRoom
	(properties
		picture 27180
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
		nextRoom 27170
	)

	(method (init)
		(self createPoly: 93 142 100 132 100 33 162 33 180 142 94 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27183
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27181
	)
)

