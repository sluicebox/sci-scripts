;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3180)
(include sci.sh)
(use Main)
(use n951)

(public
	rm3v180 0
)

(instance rm3v180 of ShiversRoom
	(properties
		picture 3180
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(gPBoatView setView: 0 nextRoom: 3220)
		(if (and (== gPrevRoomNum 3150) (proc951_11 0 3000)) ; rm3v150
			(proc951_7 20302)
			(proc951_9 20302)
			(gSounds play: 20302 -1 50 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 910) ; shiversLogo
			(gPBoatView dispose:)
			(= gPBoatView 0)
			(gSounds stop: 20303)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3190
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

