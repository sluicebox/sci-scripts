;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm26v200 0
)

(instance rm26v200 of ShiversRoom
	(properties
		picture 26200
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26170
	)

	(method (init)
		(self createPoly: 69 46 201 46 242 65 242 146 21 144 21 72)
		(super init: &rest)
	)
)

