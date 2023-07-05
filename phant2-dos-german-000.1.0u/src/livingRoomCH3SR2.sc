;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2123)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use Feature)
(use System)

(public
	livingRoomCH3SR2 0
)

(local
	[local0 4] = [231 8 311 186]
	[local4 4] = [312 8 389 186]
	[local8 4] = [363 204 389 222]
)

(instance livingRoomCH3SR2 of P2Room
	(properties
		picture 50
		style 0
		east 2133
		west 2113
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 339)
			(= global212 0)
			(ClearFlag 1001)
			(thereseNCurtis init:)
			(filler init:)
			(therese init:)
			(if (not (gP2SongPlyr isPlaying:))
				(gP2SongPlyr start: 2933)
			)
		else
			(hallFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
			(bedRoomFeat init: [local4 0] [local4 1] [local4 2] [local4 3])
			(phoneFeat init: [local8 0] [local8 1] [local8 2] [local8 3])
			(wesBook init:)
			(fidget init:)
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance hallFeat of ExitFeature
	(properties
		nextRoom 2213
		exitDir 7
		exitScene 1501
	)
)

(instance bedRoomFeat of ExitFeature
	(properties
		nextRoom 2013
		exitDir 2
		exitScene 1580
	)
)

(instance fidget of P2Fidget
	(properties
		x 132
		y 281
		view 10500
		cycleSpeed 10
		wiggler 1
		delay 1
		zone1aLeft 12
		zone1aRight 17
		zone1bLeft 18
		zone1bRight 22
		zone2aLeft 0
		zone2aRight 4
		zone2bLeft 5
		zone2bRight 10
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
		x 440
		y 308
		view 10505
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

(instance filler of View
	(properties
		x 419
		y 336
		view 10505
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
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
			init: (proc63002_10 391 220 431 151 449 151 473 223 457 263 392 264)
		)
	)
)

(instance phoneFeat of P2Feature
	(properties
		doneFlag 310
	)

	(method (init)
		(super init: &rest)
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

(instance wesBook of Feature
	(properties)

	(method (init)
		(super init: gThePlane 1 (proc63002_10 354 335 382 315 418 325 401 335))
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

