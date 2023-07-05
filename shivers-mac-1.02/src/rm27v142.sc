;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27142)
(include sci.sh)
(use Main)

(public
	rm27v142 0
)

(instance rm27v142 of ShiversRoom
	(properties
		picture 27142
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
		nextRoom 27131
	)

	(method (init)
		(self createPoly: 47 142 84 75 111 43 148 43 172 74 202 142 47 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27141
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27143
	)
)

