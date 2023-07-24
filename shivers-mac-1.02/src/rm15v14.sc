;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm15v14 0
)

(instance rm15v14 of ShiversRoom
	(properties
		picture 15140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 15160) ; rm15v16
			(gSounds fade: 21303 0 15 6 1 0)
			(proc951_7 21501)
			(gSounds play: 21501 -1 0 0)
			(gSounds fade: 21501 66 15 8 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15160
	)

	(method (init)
		(self
			createPoly: 56 142 59 128 68 112 77 97 120 25 120 0 150 0 150 25 206 129 206 141
		)
		(super init: &rest)
	)
)

