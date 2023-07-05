;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2125)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use Feature)
(use System)

(public
	livingRoomCH5SR2 0
)

(local
	[local0 4] = [363 204 389 222]
	[local4 4] = [231 8 311 186]
	[local8 4] = [312 8 389 186]
)

(instance livingRoomCH5SR2 of P2Room
	(properties
		picture 50
		style 0
		east 2135
		west 2115
	)

	(method (init)
		(hallFeat init: [local4 0] [local4 1] [local4 2] [local4 3])
		(bedRoomFeat init: [local8 0] [local8 1] [local8 2] [local8 3])
		(phoneFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
		(wesBook init:)
		(fidget init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance phoneFeat of P2Feature
	(properties
		doneFlag 726
	)

	(method (init)
		(if (and (gEgo has: 1) (IsFlag 704)) ; walletI
			(super init: &rest)
			(= whoDoit phoneCode)
			(self delVerb: 4)
			(self addVerb: 13)
		else
			(return 0)
		)
	)
)

(instance phoneCode of Code
	(properties)

	(method (doit)
		(= global211 1)
		(= global212 0)
		(SetFlag 726)
		(= global209 2810)
		(ClearFlag 1001)
		(gCurRoom newRoom: 5015) ; harburgCH5SR1
	)
)

(instance hallFeat of ExitFeature
	(properties
		nextRoom 2215
		exitDir 7
		exitScene 1501
	)
)

(instance bedRoomFeat of ExitFeature
	(properties
		nextRoom 2015
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
		(self addVerb: 21 28)
		(= whoDoit itemsOnCurtisCode)
	)
)

(instance itemsOnCurtisCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global211 1)
				(SetFlag 315)
				(proc63002_7 2145)
			)
		)
	)
)

(instance wesBook of Feature
	(properties)

	(method (init)
		(if (proc63002_4 117 270 412 583)
			(super
				init: gThePlane 1 (proc63002_10 354 335 382 315 418 325 401 335)
			)
		else
			(return 0)
		)
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

