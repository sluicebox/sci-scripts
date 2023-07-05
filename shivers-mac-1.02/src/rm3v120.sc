;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3120)
(include sci.sh)
(use Main)

(public
	rm3v120 0
)

(instance rm3v120 of ShiversRoom
	(properties
		picture 3120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if gPBoatView
			(gPBoatView setView: 2)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 3040) ; rm3v040
			(gPBoatView dispose:)
			(= gPBoatView 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3040
	)

	(method (init)
		(self
			createPoly:
				191
				37
				184
				37
				176
				41
				170
				47
				167
				52
				165
				62
				166
				89
				134
				88
				101
				97
				94
				105
				112
				114
				183
				126
				220
				119
				260
				110
				262
				95
				214
				91
				214
				51
				209
				42
				203
				38
		)
		(super init: &rest)
	)
)

