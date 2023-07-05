;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3200)
(include sci.sh)
(use Main)

(public
	rm3v200 0
)

(instance rm3v200 of ShiversRoom
	(properties
		picture 3200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(gPBoatView setView: 1 nextRoom: 3160)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 3160) ; rm3v160
			(gSounds fade: 20303 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3210
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 3040
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

