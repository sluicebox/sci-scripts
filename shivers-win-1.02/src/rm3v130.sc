;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3130)
(include sci.sh)
(use Main)

(public
	rm3v130 0
)

(instance rm3v130 of ShiversRoom
	(properties
		picture 3130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if gPBoatView
			(gPBoatView setView: 1 nextRoom: 3130)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 910) ; shiversLogo
			(gPBoatView dispose:)
			(= gPBoatView 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3140
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

