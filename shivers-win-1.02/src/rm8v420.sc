;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8420)
(include sci.sh)
(use Main)

(public
	rm8v420 0
)

(instance rm8v420 of ShiversRoom
	(properties
		picture 8420
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitLadder init: 3)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8370
	)
)

(instance efExitLadder of ExitFeature
	(properties
		nextRoom 8430
	)

	(method (init)
		(self createPoly: 175 104 80 104 105 55 155 55 174 104)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 8410
	)

	(method (init)
		(self createPoly: 30 143 30 110 237 116 237 143 30 143)
		(super init: &rest)
	)
)

