;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27292)
(include sci.sh)
(use Main)

(public
	rm27v292 0
)

(instance rm27v292 of ShiversRoom
	(properties
		picture 27292
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
		nextRoom 27283
	)

	(method (init)
		(self createPoly: 86 142 107 43 151 43 173 142 86 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27291
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27290
	)
)

