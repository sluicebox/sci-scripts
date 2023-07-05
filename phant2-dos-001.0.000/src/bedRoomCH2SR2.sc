;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2022)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use PolyEdit)
(use Polygon)
(use Feature)
(use System)

(public
	bedRoomCH2SR2 0
)

(local
	local0
)

(instance bedRoomCH2SR2 of P2Room
	(properties
		picture 20
		style 0
		west 2012
	)

	(method (init)
		(DresserFeat init: (dresserPoly init:))
		(bathRoomFeat init:)
		(fidget init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(gCast delete: checkAudio)
		(super dispose:)
	)
)

(instance DresserFeat of P2Feature
	(properties
		nextRoom 2040
	)
)

(instance dresserPoly of Polygon
	(properties)

	(method (init)
		(super init: 446 259 518 285 516 299 468 313 404 313 407 270)
		(return self)
	)
)

(instance bathRoomFeat of Feature
	(properties)

	(method (init)
		(if (not (IsFlag 268))
			(super init: gThePlane 200 (bathRoomPoly init:))
		)
	)

	(method (handleEvent event)
		(if
			(or
				(and
					(& (event modifiers:) emCTRL)
					(& (event type:) evMOUSEBUTTON)
					(< local0 6)
				)
				(and
					(& (event modifiers:) emALT)
					(& (event type:) evMOUSEBUTTON)
					(<= 6 local0 11)
				)
			)
			(event modifiers: $0000)
			(if (>= (++ local0) 12)
				(self dispose:)
				(bathRoomP2Feat init: (bathRoomPoly init:))
			)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance bathRoomP2Feat of P2Feature
	(properties
		doneFlag 268
	)

	(method (init)
		(= whoDoit takeDumpCode)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (== (event modifiers:) $0000)
			(super handleEvent: event)
		)
	)
)

(instance takeDumpCode of Code
	(properties)

	(method (doit)
		(eggAMatic add: 2022 1 50)
		(SetFlag 268)
		(fidget hide:)
		(bathDoorView init: setPri: 1)
		(gP2SoundFX play: 2810)
		(gCast add: checkAudio)
	)
)

(instance bathRoomPoly of Polygon
	(properties)

	(method (init)
		(super init: 129 23 254 27 257 309 139 310)
		(return self)
	)
)

(instance bathDoorView of View
	(properties
		x 131
		y 326
		view 20
	)
)

(instance checkAudio of Code
	(properties)

	(method (doit)
		(if (== (DoAudio audPOSITION 2810) -1)
			(gCast delete: self)
			(bathDoorView dispose:)
			(fidget show:)
		)
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

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 62 16 216 317)
		(self delVerb: 4)
		(self addVerb: 30)
		(self addVerb: 21)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(= global209 1925)
				(gEgo put: 20 get: 7) ; mailBundleI, bondageCardI
				(SetFlag 1001)
				(gCurRoom newRoom: 2122) ; livingRoomCH2SR2
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2142) ; livingRoomCH2SR4
			)
		)
	)
)

