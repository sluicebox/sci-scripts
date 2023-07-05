;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22080)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v080 0
)

(instance rm22v080 of ShiversRoom
	(properties
		picture 22080
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22030
	)

	(method (init)
		(self createPoly: 79 141 206 141 206 69 183 2 105 1 84 66 79 141)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22070
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22060
	)
)

