;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3013)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use System)

(public
	mainHallRoomCH3SR1 0
)

(instance mainHallRoomCH3SR1 of P2Room
	(properties
		picture 100
		north 3023
		south 900
	)

	(method (init)
		(ClearFlag 405)
		(SetFlag 1001)
		(if (not (gRoboGary isPlaying:))
			(gRoboGary setScore: 4 3031 2 6 12 4 3032 2 6 12 3 start:)
		)
		(curtis init:)
		(super init: &rest)
		(SetFlag 308)
		((ScriptID 63000 1) exitScene: 3370) ; sExit
		(glassDoorFeature init: (proc63002_10 248 37 329 38 325 216 248 221))
		(netRoomDoorFeature init: (proc63002_10 451 26 515 19 493 335 437 335))
		(paulsDoorFeature init: (proc63002_10 153 14 183 23 197 316 170 335))
		(officeDoorFea init:)
		(if (not (IsFlag 371))
			(sensorFeature
				init: (proc63002_10 17 203 52 198 55 242 20 255)
				addVerb: 6
				whoDoit: officeDoorCode
			)
		)
		(gGame handsOn: 1)
	)
)

(instance glassDoorFeature of ExitFeature
	(properties
		nextRoom 3023
	)
)

(instance netRoomDoorFeature of ExitFeature
	(properties
		nextRoom 3133
		exitScene 3321
	)

	(method (init)
		(if (and (IsFlag 316) (not (SetFlag 317)))
			(= scene 6240)
			(= sceneScored 1)
			(= nextRoom (= exitScene 0))
		)
		(super init: &rest)
	)
)

(instance paulsDoorFeature of P2Feature
	(properties
		scene 3322
	)
)

(instance officeDoorFea of P2Feature
	(properties)

	(method (init)
		(if (not (IsFlag 371))
			(super init: (proc63002_10 64 0 135 7 150 336 86 335))
			(= whoDoit officeDoorCode)
		)
	)
)

(instance officeDoorCode of Code
	(properties)

	(method (doit)
		(gSceneList add: 3340)
		(if (not (SetFlag 375))
			(gSceneList add: 5870)
			(gCurRoom newRoom: 4023) ; curtisCubicleRoomCH3SR2
			(SetFlag 325)
		else
			(gCurRoom newRoom: 3313) ; mainOfficeRoomCH3SR1
		)
	)
)

(instance sensorFeature of P2Feature
	(properties)
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

