;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27163)
(include sci.sh)
(use Main)

(public
	rm27v163 0
)

(instance rm27v163 of ShiversRoom
	(properties
		picture 27163
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
		nextRoom 27173
	)

	(method (init)
		(self createPoly: 82 142 98 33 162 33 170 142 82 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27162
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27160
	)
)

