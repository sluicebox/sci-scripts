;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20600)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v600 0
)

(instance rm20v600 of ShiversRoom
	(properties
		picture 20600
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
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
		nextRoom 20760
	)

	(method (init)
		(self createPoly: 51 5 149 5 149 140 55 140 55 5)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20610
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20580
	)
)

