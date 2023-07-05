;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30240)
(include sci.sh)
(use Main)

(public
	rm30v240 0
)

(instance rm30v240 of ShiversRoom
	(properties
		picture 30240
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (<= 20000 newRoomNumber 30000)
			(gSounds fade: 23001 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30230
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 30230
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

