;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6012)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	blEntranceCH2SR1 0
)

(instance blEntranceCH2SR1 of P2Room
	(properties
		south 900
	)

	(method (init)
		(SetFlag 1001)
		(if (not (IsFlag 222))
			(= picture 441)
			(closedFidget init:)
		else
			(if (not (IsFlag 217))
				(= global209 7680)
				(SetFlag 217)
			)
			((ScriptID 63000 1) exitScene: 7691) ; sExit
			(bouncer init:)
			(bouncerFidget init:)
			(bike init:)
			(fidget init:)
			(doorFeat init:)
			(= picture 440)
		)
		(super init: &rest)
		(if (IsFlag 217)
			(gP2SongPlyr start: 6910)
		)
		(gGame handsOn: 1)
	)
)

(instance bouncer of P2Feature
	(properties)

	(method (init)
		(if (IsFlag 211)
			(return 0)
		else
			(super init: 337 42 406 220)
			(if (not (IsFlag 212))
				(self addVerb: 11)
			)
			(if (not (IsFlag 211))
				(self addVerb: 12)
			)
			(if (IsFlag 210)
				(self delVerb: 4)
			)
			(= whoDoit bouncerCode)
		)
	)
)

(instance bouncerCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(4 ; Do
				(= global211 1)
				(proc63002_7 7690)
				(SetFlag 210)
				(bouncer delVerb: 4)
			)
			(11 ; sexyCardI
				(= global211 1)
				(proc63002_7 7720)
				(SetFlag 212)
				(bouncer delVerb: 11)
			)
			(12 ; bondageCardI
				(SetFlag 211)
				(gP2SongPlyr stop:)
				(= global209 7730)
				(gCurRoom newRoom: 6212) ; blDanceCH2SR1
			)
		)
	)
)

(instance doorFeat of ExitFeature
	(properties
		readyFlag 211
		nextRoom 6212
		exitDir 1
	)

	(method (init)
		(= exitScene (Random 7735 7736))
		(super init: (proc63002_10 399 9 461 20 456 234 401 243))
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gP2SongPlyr stop:)
		)
		(event claimed:)
	)
)

(instance bike of View
	(properties
		x 105
		y 278
		view 440
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance fidget of P2Fidget
	(properties
		x 187
		y 338
		view 14400
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 8
		zone1aRight 10
		zone1bLeft 11
		zone1bRight 19
		zone2aLeft 20
		zone2aRight 25
		zone2bLeft 26
		zone2bRight 30
	)

	(method (init)
		(super init:)
		(self setPri: 30)
	)
)

(instance bouncerFidget of P2Fidget
	(properties
		x 335
		y 308
		view 14401
		initStart 2
		initFinish 3
		cycleFinish 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance closedFidget of P2Fidget
	(properties
		x 186
		y 339
		view 14402
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 8
		zone1aRight 10
		zone1bLeft 11
		zone1bRight 19
		zone2aLeft 20
		zone2aRight 25
		zone2bLeft 26
		zone2bRight 30
	)

	(method (init)
		(super init:)
		(self setPri: 30)
	)
)

