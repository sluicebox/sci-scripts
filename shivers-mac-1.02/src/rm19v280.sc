;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19280)
(include sci.sh)
(use Main)

(public
	rm19v280 0
)

(instance rm19v280 of ShiversRoom
	(properties
		picture 19280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 19120) ; rm19v120
			(gSounds fade: 21910 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19120
	)

	(method (init)
		(self
			createPoly: 74 143 95 129 96 41 105 26 131 20 160 25 165 32 164 142
		)
		(super init: &rest)
	)
)

