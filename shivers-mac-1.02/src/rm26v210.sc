;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26210)
(include sci.sh)
(use Main)
(use n951)

(public
	rm26v210 0
)

(instance rm26v210 of ShiversRoom
	(properties
		picture 26210
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26230
	)

	(method (init)
		(self createPoly: 55 100 42 0 225 0 212 99)
		(super init: &rest)
	)
)

