;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13302)
(include sci.sh)
(use Main)

(public
	rm13v302 0
)

(instance rm13v302 of ShiversRoom
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
		nextRoom 13300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13303
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13256
	)

	(method (init)
		(self createPoly: 69 143 100 107 100 36 178 36 178 122 198 142)
		(super init: &rest)
	)
)

