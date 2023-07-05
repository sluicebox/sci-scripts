;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27050)
(include sci.sh)
(use Main)

(public
	rm27v050 0
)

(instance rm27v050 of ShiversRoom
	(properties
		picture 27050
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
		nextRoom 27060
	)

	(method (init)
		(self createPoly: 91 142 116 49 151 49 178 142 92 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27051
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27051
	)
)

