;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2122)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use P2Fidget)
(use Polygon)
(use Feature)
(use System)

(public
	livingRoomCH2SR2 0
)

(local
	[local0 4] = [231 8 311 186]
	[local4 4] = [312 8 389 186]
	[local8 4] = [363 204 389 222]
)

(instance livingRoomCH2SR2 of P2Room
	(properties
		picture 50
		style 0
		east 2132
		west 2112
	)

	(method (init)
		(hallFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
		(bedRoomFeat init: [local4 0] [local4 1] [local4 2] [local4 3])
		(phoneFeat init: [local8 0] [local8 1] [local8 2] [local8 3])
		(wesBook init:)
		(polaroid init:)
		(fidget init:)
		(super init: &rest)
		(if (not (IsFlag 249))
			(SetFlag 249)
			(gP2SongPlyr start: 2920 70)
			(SetFlag 1001)
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance phoneFeat of P2Feature
	(properties
		scene 1780
		sceneScored 1
		doneFlag 209
	)

	(method (init)
		(super init: &rest)
		(self delVerb: 4)
		(self addVerb: 13)
	)
)

(instance polaroid of P2View
	(properties
		x 292
		y 332
		view 50
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
		(super init: 306 322 309 313 328 315 324 324)
		(return self)
	)
)

(instance hallFeat of ExitFeature
	(properties
		nextRoom 2212
		exitDir 7
		exitScene 1501
	)
)

(instance bedRoomFeat of ExitFeature
	(properties
		nextRoom 2012
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
				(gEgo put: 20 get: 7) ; mailBundleI, bondageCardI
				(SetFlag 1001)
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2142) ; livingRoomCH2SR4
			)
		)
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

