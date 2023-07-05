;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16080)
(include sci.sh)
(use Main)

(public
	rm16v80 0
)

(instance rm16v80 of ShiversRoom
	(properties
		picture 16080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16050
	)

	(method (init)
		(self createPoly: 61 145 105 97 106 54 154 54 155 96 198 143)
		(super init: &rest)
	)
)

