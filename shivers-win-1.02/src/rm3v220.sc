;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm3v220 0
)

(instance rm3v220 of ShiversRoom
	(properties
		picture 3220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(gPBoatView setView: 0 nextRoom: 3260)
		(if (and (== gPrevRoomNum 3180) (proc951_11 0 3000)) ; rm3v180
			(proc951_9 20303)
			(gSounds play: 20303 -1 50 0)
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
		nextRoom 3210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3230
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

