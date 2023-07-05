;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3140)
(include sci.sh)
(use Main)

(public
	rm3v140 0
)

(instance rm3v140 of ShiversRoom
	(properties
		picture 3140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if gPBoatView
			(gPBoatView setView: 2)
		else
			((ScriptID 3001) init: setView: 2) ; pBoatView
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
		nextRoom 3130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3150
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

