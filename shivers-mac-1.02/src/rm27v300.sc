;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27300)
(include sci.sh)
(use Main)

(public
	rm27v300 0
)

(instance rm27v300 of ShiversRoom
	(properties
		picture 27300
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
		nextRoom 27041
	)

	(method (init)
		(self createPoly: 88 142 120 56 143 56 176 142 88 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27301
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27301
	)
)

