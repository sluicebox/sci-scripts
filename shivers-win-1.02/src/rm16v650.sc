;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16650)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v650 0
)

(instance rm16v650 of ShiversRoom
	(properties
		picture 16650
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16640
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16640
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16280
	)

	(method (init)
		(self createPoly: 67 145 83 121 64 45 69 35 64 15 127 42 158 72 210 145)
		(super init: &rest)
	)
)

