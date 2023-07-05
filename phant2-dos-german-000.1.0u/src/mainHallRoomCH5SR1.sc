;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3015)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)

(public
	mainHallRoomCH5SR1 0
)

(instance mainHallRoomCH5SR1 of P2Room
	(properties
		picture 100
		north 3025
		south 900
	)

	(method (init)
		(curtis init:)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 3051)
		((ScriptID 63000 1) exitScene: 3370) ; sExit
		(glassDoorFeature init: (proc63002_10 248 37 329 38 325 216 248 221))
		(netRoomDoorFeature init:)
		(paulsDoorFeature init: (proc63002_10 153 14 183 23 197 316 170 335))
		(officeDoorFea init: (proc63002_10 64 0 135 7 150 336 86 335))
		(sensorFeature
			init: (proc63002_10 17 203 52 198 55 242 20 255)
			addVerb: 6
			addVerb: 36
		)
		(gGame handsOn: 1)
	)
)

(instance glassDoorFeature of ExitFeature
	(properties
		nextRoom 3025
	)
)

(instance netRoomDoorFeature of ExitFeature
	(properties)

	(method (init)
		(super init: (proc63002_10 451 26 515 19 493 335 437 335))
		(if (not (gEgo has: 26)) ; trevCardKeyI
			(= nextRoom 3135)
			(= exitScene (if (IsFlag 756) 4930 else 3321))
		else
			(= scene 4940)
		)
	)
)

(instance paulsDoorFeature of ExitFeature
	(properties
		nextRoom 4615
		exitScene 4371
	)
)

(instance officeDoorFea of ExitFeature
	(properties
		nextRoom 3315
		exitScene 3340
	)
)

(instance sensorFeature of ExitFeature
	(properties
		nextRoom 3315
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

