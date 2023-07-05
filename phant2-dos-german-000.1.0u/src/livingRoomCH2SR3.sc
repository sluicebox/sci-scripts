;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2132)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)
(use Polygon)
(use Feature)
(use System)

(public
	livingRoomCH2SR3 0
)

(local
	[local0 4] = [453 68 534 245]
)

(instance livingRoomCH2SR3 of P2Room
	(properties
		picture 60
		style 0
		south 2112
		west 2122
	)

	(method (init)
		(bookCaseFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
		(phoneFeat init:)
		(polaroid init:)
		(fidget init:)
		(jukeBox init:)
		(teamPhoto init:)
		(wesBook init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance bookCaseFeat of P2Feature
	(properties
		scene 1910
		sceneScored 1
		readyFlag 200
		doneFlag 208
	)
)

(instance polaroid of P2View
	(properties
		x 369
		y 302
		view 60
		nextRoom 2190
	)

	(method (init)
		(if (not (IsFlag 94))
			(super init: &rest)
			(self addTarget: (tablePoly init:))
		else
			(return 0)
		)
	)
)

(instance tablePoly of Polygon
	(properties)

	(method (init)
		(super init: 369 285 389 285 391 292 373 293)
		(return self)
	)
)

(instance phoneFeat of P2Feature
	(properties
		scene 1780
		sceneScored 1
		doneFlag 209
	)

	(method (init)
		(super init: 101 264 144 291)
		(self delVerb: 4)
		(self addVerb: 13)
	)
)

(instance fidget of P2Fidget
	(properties
		x 227
		y 344
		view 10600
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 0
		zone1aRight 10
		zone1bLeft 11
		zone1bRight 21
		zone2aLeft 22
		zone2aRight 32
		zone2bLeft 33
		zone2bRight 42
	)

	(method (init)
		(super init:)
		(curtisFeat init: left top right bottom)
		(self setPri: 1)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
		(self delVerb: 4)
		(self addVerb: 30)
		(self addVerb: 21)
		(= whoDoit itemsOnCurtisCode)
	)
)

(instance itemsOnCurtisCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(proc63002_7 1921)
				(SetFlag 1001)
				(gEgo put: 20 get: 7) ; mailBundleI, bondageCardI
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2142) ; livingRoomCH2SR4
			)
		)
	)
)

(instance jukeBox of Feature
	(properties)

	(method (init)
		(super init: gThePlane 100 606 216 636 248)
		(= scratch 0)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(self scratch: (+ (self scratch:) 1))
			(if (== (self scratch:) 10)
				(eggAMatic add: 2131 8 5)
				(gCurRoom newRoom: 2900) ; jukeRoom
			)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance teamPhoto of P2Feature
	(properties
		nextRoom 2130
	)

	(method (init)
		(super init: 414 128 433 143)
		(if (not (Random 0 9))
			(switch (Random 1 3)
				(1
					(outsidePic init:)
				)
				(2
					(loversPic init:)
				)
				(3
					(pizzaPic init:)
				)
			)
		)
	)
)

(instance outsidePic of P2Feature
	(properties
		nextRoom 2137
	)

	(method (init)
		(super init: 567 65 599 93)
	)
)

(instance loversPic of P2Feature
	(properties
		nextRoom 2138
	)

	(method (init)
		(super init: 571 104 592 142)
	)
)

(instance pizzaPic of P2Feature
	(properties
		nextRoom 2139
	)

	(method (init)
		(super init: 563 156 597 180)
	)
)

(instance wesBook of Feature
	(properties)

	(method (init)
		(super init: gThePlane 1 369 264 415 276)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event modifiers:) emALT)
				(& (event modifiers:) emCTRL)
				(& (event type:) evMOUSEBUTTON)
			)
			(gCurRoom newRoom: 2171) ; bookRoom
			(event claimed: 1)
		)
		(event claimed:)
	)
)

