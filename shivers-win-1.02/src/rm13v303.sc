;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13303)
(include sci.sh)
(use Main)

(public
	rm13v303 0
)

(instance rm13v303 of ShiversRoom
	(properties
		picture 13390
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13302
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13299
	)

	(method (init)
		(self createPoly: 64 142 76 129 75 30 166 30 166 110 192 142)
		(super init: &rest)
	)
)

