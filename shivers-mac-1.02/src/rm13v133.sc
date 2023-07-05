;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13133)
(include sci.sh)
(use Main)

(public
	rm13v133 0
)

(instance rm13v133 of ShiversRoom
	(properties
		picture 13300
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13134
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13132
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13023
	)

	(method (init)
		(self createPoly: 63 142 103 107 103 37 182 37 182 125 193 142)
		(super init: &rest)
	)
)

