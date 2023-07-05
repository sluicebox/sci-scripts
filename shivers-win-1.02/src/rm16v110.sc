;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16110)
(include sci.sh)
(use Main)

(public
	rm16v110 0
)

(instance rm16v110 of ShiversRoom
	(properties
		picture 16110
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16130
	)

	(method (init)
		(self createPoly: 36 142 55 129 56 93 21 92 21 3 210 3 210 111 250 144)
		(super init: &rest)
	)
)

