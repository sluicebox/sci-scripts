;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13447)
(include sci.sh)
(use Main)

(public
	rm13v447 0
)

(instance rm13v447 of ShiversRoom
	(properties
		picture 13710
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
		nextRoom 13445
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13446
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13443
	)

	(method (init)
		(self createPoly: 76 142 112 105 112 42 168 42 168 107 226 142)
		(super init: &rest)
	)
)

