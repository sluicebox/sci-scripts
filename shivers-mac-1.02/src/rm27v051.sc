;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27051)
(include sci.sh)
(use Main)

(public
	rm27v051 0
)

(instance rm27v051 of ShiversRoom
	(properties
		picture 27051
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
		nextRoom 27042
	)

	(method (init)
		(self createPoly: 85 143 109 47 151 47 170 142 86 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27050
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27050
	)
)

