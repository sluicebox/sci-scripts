;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13108)
(include sci.sh)
(use Main)

(public
	rm13v108 0
)

(instance rm13v108 of ShiversRoom
	(properties
		picture 13410
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
		nextRoom 13111
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13109
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13112
	)

	(method (init)
		(self createPoly: 69 143 100 107 100 36 178 36 178 122 198 142)
		(super init: &rest)
	)
)

