;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3290)
(include sci.sh)
(use Main)

(public
	rm3v290 0
)

(instance rm3v290 of ShiversRoom
	(properties
		picture 3290
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(gPBoatView setView: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 3440) ; rm3v440
			(gPBoatView dispose:)
			(= gPBoatView 0)
			(gSounds stop: 20303)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3440
	)

	(method (init)
		(self
			createPoly: 105 115 126 104 151 54 150 4 239 19 239 127 198 123 145 121
		)
		(super init: &rest)
	)
)

