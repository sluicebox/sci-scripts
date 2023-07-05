;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v220 0
)

(instance rm23v220 of ShiversRoom
	(properties
		picture 23220
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23270
	)

	(method (init)
		(self createPoly: 60 20 25 142 239 142 206 19 60 19)
		(super init: &rest)
	)
)

