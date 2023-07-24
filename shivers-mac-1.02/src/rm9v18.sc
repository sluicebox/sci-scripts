;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9180)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v18 0
)

(instance rm9v18 of ShiversRoom
	(properties
		picture 9180
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitDesk init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9190
	)

	(method (init)
		(self
			createPoly: 264 0 243 0 243 55 250 47 263 47 263 96 243 95 243 143 263 143
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9220
	)

	(method (init)
		(self createPoly: 43 82 43 14 17 0 56 0 97 17 105 34 100 47 100 83)
		(super init: &rest)
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 9910
	)

	(method (init)
		(self createPoly: 137 53 136 85 258 96 262 96 265 56)
		(super init: &rest)
	)
)

