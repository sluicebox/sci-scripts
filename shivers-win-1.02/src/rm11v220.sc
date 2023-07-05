;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v220 0
)

(instance rm11v220 of ShiversRoom
	(properties
		picture 11220
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efLadder init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11320
	)

	(method (init)
		(self createPoly: 47 138 47 40 78 20 115 20 144 40 144 135)
		(super init: &rest)
	)
)

(instance efLadder of ExitFeature
	(properties
		nextRoom 11250
	)

	(method (init)
		(self createPoly: 212 135 252 46 252 101 239 136 220 143 212 136)
		(super init: &rest)
	)
)

