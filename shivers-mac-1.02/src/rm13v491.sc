;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13491)
(include sci.sh)
(use Main)

(public
	rm13v491 0
)

(instance rm13v491 of ShiversRoom
	(properties
		picture 13540
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13490
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13490
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13493
	)

	(method (init)
		(self createPoly: 57 143 72 128 72 13 176 13 176 127 216 142)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13497
	)

	(method (init)
		(self createPoly: 175 127 175 16 215 0 215 141)
		(super init: &rest)
	)
)

