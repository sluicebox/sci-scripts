;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2024)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	bedRoomCH4SR2 0
)

(instance bedRoomCH4SR2 of P2Room
	(properties
		picture 20
		style 0
		west 2014
	)

	(method (init)
		(fidget init:)
		(dresserFeat init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance fidget of P2Fidget
	(properties
		x 86
		y 338
		view 10200
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 18
		zone1aRight 15
		zone1bLeft 14
		zone1bRight 11
		zone2aLeft 10
		zone2aRight 6
		zone2bLeft 5
		zone2bRight 0
	)

	(method (init)
		(super init:)
		(curtisFeat init:)
		(self setPri: 1)
	)
)

(instance dresserFeat of P2Feature
	(properties
		nextRoom 2040
	)

	(method (init)
		(super
			init: (proc63002_10 446 259 518 285 516 299 468 313 404 313 407 270)
		)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 62 16 216 317)
		(self delVerb: 4)
		(self addVerb: 30 21 28)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(= global211 1)
				(= global209 2425)
				(gEgo put: 20 get: 24) ; mailBundleI, thereseNoteI
				(SetFlag 1001)
				(gCurRoom newRoom: 2124) ; livingRoomCH4SR2
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global209 2145)
				(= global211 1)
				(SetFlag 315)
				(gCurRoom newRoom: 2124) ; livingRoomCH4SR2
			)
		)
	)
)

