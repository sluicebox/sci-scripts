;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2133)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use Feature)
(use System)

(public
	livingRoomCH3SR3 0
)

(local
	[local0 4] = [453 68 534 245]
)

(instance livingRoomCH3SR3 of P2Room
	(properties
		picture 60
		style 0
		south 2113
		west 2123
	)

	(method (init)
		(if (IsFlag 339)
			(ClearFlag 1001)
			(= global212 0)
			(thereseNCurtis init:)
			(therese init:)
			(= picture 61)
		else
			(bookCaseFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
			(fidget init:)
			(jukeBox init:)
			(teamPhoto init:)
			(wesBook init:)
			(phoneFeat init:)
			(= picture 60)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance bookCaseFeat of P2Feature
	(properties
		scene 2060
		sceneScored 1
		readyFlag 308
		doneFlag 307
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
		(self addVerb: 21 30 28)
		(= whoDoit itemsOnCurtisCode)
	)
)

(instance itemsOnCurtisCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2143) ; livingRoomCH3SR4
			)
			(30 ; mailBundleI
				(gEgo put: 20) ; mailBundleI
				(proc63002_7 2061)
				(if (IsFlag 310)
					(SetFlag 1001)
				)
			)
			(28 ; dadLetterI
				(= global211 1)
				(SetFlag 315)
				(proc63002_7 2145)
			)
		)
	)
)

(instance thereseNCurtis of P2Fidget
	(properties
		x 149
		y 330
		view 10612
		cycleSpeed 8
		initStart 3
		initFinish 6
		cycleStart 3
		cycleFinish 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance therese of ExitFeature
	(properties
		priority 30
		sceneScored 1
		doneFlag 300
		nextRoom 2033
		exitScene 2140
	)

	(method (init)
		(super
			init:
				(proc63002_10
					200
					182
					191
					135
					201
					126
					205
					88
					232
					89
					236
					127
					249
					129
					282
					190
					274
					230
					249
					208
				)
		)
	)
)

(instance phoneFeat of P2Feature
	(properties
		doneFlag 310
	)

	(method (init)
		(super init: 101 264 144 291)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gP2SongPlyr stop:)
			(= global209 2090)
			(gCurRoom newRoom: 2213) ; aptHallCH3SR1
		)
		(event claimed:)
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

