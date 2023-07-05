;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2121)
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
	livingRoomCH1SR2 0
)

(local
	[local0 4] = [231 8 311 186]
	[local4 4] = [312 8 389 186]
)

(instance livingRoomCH1SR2 of P2Room
	(properties
		picture 50
		style 0
		east 2131
		west 2111
	)

	(method (init)
		(hallFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
		(bedRoomFeat init: [local4 0] [local4 1] [local4 2] [local4 3])
		(couchFeat init:)
		(wesBook init:)
		(polaroid init:)
		(fidget init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance couchFeat of P2Feature
	(properties)

	(method (init)
		(if (and (IsFlag 19) (not (IsFlag 38)))
			(= whoDoit couchClicked)
			(super init: (proc63002_10 425 193 629 224 569 313 348 250 412 233))
			(if (IsFlag 13)
				(self delVerb: 4)
			)
			(if
				(and
					(not (IsFlag 16))
					(not (IsFlag 38))
					(IsFlag 13)
				)
				(self addVerb: 31)
			)
			(if (and (IsFlag 16) (not (IsFlag 38)))
				(self addVerb: 7)
			)
		else
			(return 0)
		)
	)
)

(instance couchClicked of Code
	(properties)

	(method (doit)
		(cond
			((and (not (IsFlag 13)) (IsFlag 19))
				(couchFeat delVerb: 4 addVerb: 31)
				(proc63002_7 1420)
				(SetFlag 13)
			)
			((and (IsFlag 16) (not (IsFlag 38)))
				(couchFeat delVerb: 7)
				(proc63002_7 1370)
				(SetFlag 38)
				(gEgo get: 1) ; walletI
				(gEgo get: 21) ; ratI
				(gEgo put: 3) ; candyI
			)
			(
				(and
					(not (IsFlag 16))
					(not (IsFlag 38))
					(IsFlag 13)
				)
				(couchFeat delVerb: 31 addVerb: 7)
				(proc63002_7 1360)
				(SetFlag 16)
				(gEgo put: 21) ; ratI
			)
		)
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
		nextRoom 2211
		exitDir 7
		exitScene 1501
	)
)

(instance bedRoomFeat of ExitFeature
	(properties
		nextRoom 2011
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
		(= whoDoit mailOnCurtisCode)
	)
)

(instance mailOnCurtisCode of Code
	(properties)

	(method (doit)
		(curtisFeat delVerb: 30)
		(proc63002_7 1520)
		(gEgo put: 20 get: 6) ; mailBundleI, sexyCardI
		(if (IsFlag 112)
			(SetFlag 1001)
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

