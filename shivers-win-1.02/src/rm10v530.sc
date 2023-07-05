;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10530)
(include sci.sh)
(use Main)

(public
	rm10v530 0
)

(instance rm10v530 of ShiversRoom
	(properties
		picture 10530
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 8250) ; rm8v250
			(gSounds fadeChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10520
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8250
	)

	(method (init)
		(self createPoly: 71 143 69 0 198 0 195 142)
		(super init: &rest)
	)
)

