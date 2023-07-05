;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3300)
(include sci.sh)
(use Main)
(use n951)

(public
	rm3v300 0
)

(instance rm3v300 of ShiversRoom
	(properties
		picture 3300
	)

	(method (init)
		(if (IsFlag 5)
			(self picture: 3301)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(gPBoatView setView: 0 nextRoom: 3300)
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
		nextRoom 3290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3310
	)
)

