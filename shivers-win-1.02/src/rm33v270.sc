;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33270)
(include sci.sh)
(use Main)

(public
	rm33v270 0
)

(instance rm33v270 of ShiversRoom
	(properties
		picture 33270
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27124
	)

	(method (init)
		(self createPoly: 48 142 95 113 95 35 175 35 175 113 222 142 49 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33030
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33030
	)
)

