;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3012)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use System)

(public
	mainHallRoomCH2SR1 0
)

(instance mainHallRoomCH2SR1 of P2Room
	(properties
		picture 100
		north 3022
		south 900
	)

	(method (init)
		((ScriptID 63000 1) exitScene: 3370) ; sExit
		(SetFlag 200)
		(if (not (IsFlag 228))
			(gP2SongPlyr start: 3020 50)
		)
		(if (not (SetFlag 223))
			(ClearFlag 1001)
			(= picture 101)
			(= global209 3880)
			(everybodysChick init:)
			(kennysChick init:)
			(jaysChick init:)
			(super init: &rest)
			((ScriptID 63000 1) exitDir: -1 delVerb: 4) ; sExit
			((ScriptID 63000 0) exitDir: -1 delVerb: 4) ; nExit
		else
			(= picture 100)
			(super init: &rest)
			(doorFeatureInitCode doit:)
			(if (and (IsFlag 228) (not (gRoboGary isPlaying:)))
				(gRoboGary
					setScore: 4 (if (IsFlag 227) 3022 else 3021) 2 8 12 3
					start:
				)
			)
		)
		(gGame handsOn: 1)
	)
)

(instance jocFeat of P2Feature
	(properties
		scene 4420
		doneFlag 224
	)

	(method (init)
		(super init: 383 121 466 325)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(everybodysChick dispose:)
			(doorFeatureInitCode doit:)
			(event claimed:)
			(return)
		)
	)
)

(instance trevFeat of P2Feature
	(properties
		scene 4440
		doneFlag 226
	)

	(method (init)
		(super init: 254 67 330 325)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(kennysChick dispose:)
			(doorFeatureInitCode doit:)
			(event claimed:)
			(return)
		)
	)
)

(instance thereseFeat of P2Feature
	(properties
		scene 4430
		doneFlag 225
	)

	(method (init)
		(super init: 142 57 192 321)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(jaysChick dispose:)
			(doorFeatureInitCode doit:)
			(event claimed:)
			(return)
		)
	)
)

(instance glassDoorFeature of ExitFeature
	(properties
		nextRoom 3022
	)
)

(instance netRoomDoorFeature of ExitFeature
	(properties
		nextRoom 3132
		exitScene 3321
	)
)

(instance paulDistPaulsDoorFeature of ExitFeature
	(properties
		readyFlag 227
		nextRoom 4632
		exitScene 4371
	)

	(method (init)
		(cond
			((and (not (IsFlag 251)) (super init:))
				(target dispose:)
				(= target 0)
				(self addTarget: (proc63002_10 153 14 183 23 197 316 170 335))
				(return 1)
			)
			((IsFlag 251)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance paulHerePaulsDoorFeature of P2Feature
	(properties
		scene 3883
		readyFlag 228
		doneFlag 229
	)

	(method (init)
		(if (super init:)
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 153 14 183 23 197 316 170 335))
			(return 1)
		)
	)
)

(instance bobHerePaulsDoorFeature of ExitFeature
	(properties
		nextRoom 4632
		exitScene 3882
	)

	(method (init)
		(if (and (not (IsFlag 228)) (super init:))
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 153 14 183 23 197 316 170 335))
			(return 1)
		)
	)
)

(instance noBobOfficeDoorFea of P2Feature
	(properties
		readyFlag 228
	)

	(method (init)
		(if (super init:)
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 64 0 135 7 150 336 86 335))
			(= whoDoit noBobODCode)
			(return 1)
		)
	)
)

(instance noBobODCode of Code
	(properties)

	(method (doit)
		(if (not (SetFlag 231))
			(proc63002_7 3340 5830)
		else
			(= global209 3340)
			(gCurRoom newRoom: 3312) ; mainOfficeRoomCH2SR1
		)
	)
)

(instance bobHereOfficeDoorFea of P2Feature
	(properties
		scene 3881
		doneFlag 230
	)

	(method (init)
		(if (super init:)
			(sensorFeature
				init: (proc63002_10 17 203 52 198 55 242 20 255)
				addVerb: 6
				whoDoit: sensorCode
			)
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 64 0 135 7 150 336 86 335))
			(return 1)
		)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(sensorFeature delVerb: 4)
			(sensorFeature delVerb: 6)
		)
	)
)

(instance sensorFeature of P2Feature
	(properties)
)

(instance sensorCode of Code
	(properties)

	(method (doit)
		(if (IsFlag 228)
			(noBobODCode doit:)
		else
			(SetFlag 230)
			(proc63002_7 3881)
			(bobHereOfficeDoorFea delVerb: 4)
			(sensorFeature delVerb: 6)
			(sensorFeature delVerb: 4)
		)
	)
)

(instance doorFeatureInitCode of Code
	(properties)

	(method (doit)
		(if (proc63002_4 224 225 226)
			(gCurRoom drawPic: 100)
			(glassDoorFeature
				init: (proc63002_10 248 37 329 38 325 216 248 221)
			)
			(netRoomDoorFeature
				init: (proc63002_10 451 26 515 19 493 335 437 335)
			)
			(or
				(paulDistPaulsDoorFeature init:)
				(paulHerePaulsDoorFeature init:)
				(bobHerePaulsDoorFeature init:)
			)
			(or (noBobOfficeDoorFea init:) (bobHereOfficeDoorFea init:))
			((ScriptID 63000 1) exitDir: 4 addVerb: 4) ; sExit
			((ScriptID 63000 0) exitDir: 0 addVerb: 4) ; nExit
			(curtis init:)
			(SetFlag 1001)
		)
	)
)

(instance everybodysChick of P2Fidget
	(properties
		x 379
		y 340
		view 11013
		initStart 0
		initFinish 0
		cycleStart 2
		cycleFinish 5
	)

	(method (init)
		(super init: &rest)
		(jocFeat init:)
		(self setPri: 10)
	)
)

(instance kennysChick of P2Fidget
	(properties
		x 248
		y 337
		view 11014
		initStart 1
		initFinish 4
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init: &rest)
		(trevFeat init:)
		(self setPri: 10)
	)
)

(instance jaysChick of P2Fidget
	(properties
		x 125
		y 334
		view 11015
		initStart 1
		initFinish 3
		cycleStart 2
		cycleFinish 9
	)

	(method (init)
		(super init: &rest)
		(thereseFeat init:)
		(self setPri: 10)
	)
)

(instance curtis of P2Fidget
	(properties
		x 253
		y 352
		view 11002
		initStart 0
		initFinish 3
		cycleStart 10
		cycleFinish 20
	)
)

