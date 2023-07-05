;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3160)
(include sci.sh)
(use Main)

(public
	rm3v160 0
)

(instance rm3v160 of ShiversRoom
	(properties
		picture 3160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(gPBoatView setView: 1 nextRoom: 3130)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 3130) ; rm3v130
			(gSounds fade: 20302 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3170
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

