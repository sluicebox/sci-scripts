;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3014)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use System)

(public
	mainHallRoomCH4SR1 0
)

(instance mainHallRoomCH4SR1 of P2Room
	(properties
		picture 100
		north 3024
		south 900
	)

	(method (init)
		(gP2SongPlyr fadeIn: (if (IsFlag 521) 3041 else 3042))
		(curtis init:)
		(super init: &rest)
		(SetFlag 500)
		((ScriptID 63000 1) exitScene: 3370) ; sExit
		(glassDoorFeature init: (proc63002_10 248 37 329 38 325 216 248 221))
		(netRoomDoorFeature init: (proc63002_10 451 26 515 19 493 335 437 335))
		(paulsDoorFeature
			init: (proc63002_10 153 14 183 23 197 316 170 335)
			whoDoit: paulsDoorCode
		)
		(officeDoorFea init: (proc63002_10 64 0 135 7 150 336 86 335))
		(sensorFeature
			init: (proc63002_10 17 203 52 198 55 242 20 255)
			addVerb: 6
		)
		(gGame handsOn: 1)
	)
)

(instance glassDoorFeature of ExitFeature
	(properties
		nextRoom 3024
	)
)

(instance netRoomDoorFeature of ExitFeature
	(properties
		nextRoom 3134
		exitScene 3321
	)
)

(instance paulsDoorFeature of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 520))
			(self addVerb: 15)
		)
		(if (not (IsFlag 521))
			(self addVerb: 25)
		)
	)
)

(instance paulsDoorCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(15 ; screwdriverI
				(if (not (SetFlag 520))
					(proc63002_7 4742)
					(paulsDoorFeature delVerb: 15)
				)
			)
			(25 ; hairpinI
				(if (not (SetFlag 521))
					(= global209 4743)
					(gCurRoom newRoom: 4614) ; paulsOfficeRoomCH4SR1
				)
			)
			(else
				(if (IsFlag 521)
					(= global209 4371)
					(gCurRoom newRoom: 4614) ; paulsOfficeRoomCH4SR1
				else
					(proc63002_7 3322)
				)
			)
		)
	)
)

(instance officeDoorFea of ExitFeature
	(properties
		nextRoom 3314
		exitScene 3340
	)
)

(instance sensorFeature of ExitFeature
	(properties
		nextRoom 3314
		exitScene 3340
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

