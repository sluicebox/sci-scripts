;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3011)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use System)

(public
	mainHallRoomCH1SR1 0
)

(instance mainHallRoomCH1SR1 of P2Room
	(properties
		picture 100
		north 3021
		south 900
	)

	(method (init)
		(SetFlag 1001)
		(= global241 100)
		(cond
			((and (IsFlag 46) (not (IsFlag 45)))
				(if (not (gRoboGary isPlaying:))
					(gRoboGary setScore: 4 3013 2 10 20 3 start:)
				)
			)
			((not (== gPrevRoomNum 7001)) ; dreamingTreeRoomCH1
				(gP2SongPlyr
					fadeIn:
						(cond
							((IsFlag 45) 3014)
							((IsFlag 26) 3012)
							(else 3011)
						)
				)
			)
		)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 100)
		(if (gCast contains: (ScriptID 4391 0)) ; justTalkedToBob
			(gCast delete: (ScriptID 4391 0)) ; justTalkedToBob
			(Lock rsSCRIPT 4391 0)
			(DisposeScript 4391)
		)
		(curtis init:)
		(super init: &rest)
		(if (== gPrevRoomNum 7001) ; dreamingTreeRoomCH1
			(gP2SongPlyr fadeIn: 3014 100)
		)
		((ScriptID 63000 1) exitScene: 3370) ; sExit
		(glassDoorFeature init: (proc63002_10 248 37 329 38 325 216 248 221))
		(netRoomDoorFeature init: (proc63002_10 451 26 515 19 493 335 437 335))
		(paulsDoorFeature init: (proc63002_10 153 14 183 23 197 316 170 335))
		(sensorFeature
			init: (proc63002_10 17 203 52 198 55 242 20 255)
			addVerb: 6
			whoDoit: sensorCode
		)
		(or (usedKeyFea init:) (officeDoorFea init:))
		(gGame handsOn: 1)
	)
)

(instance glassDoorFeature of ExitFeature
	(properties
		nextRoom 3021
	)
)

(instance netRoomDoorFeature of ExitFeature
	(properties)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(if
				(and
					(proc63002_4 26 27)
					(or (IsFlag 24) (not (IsFlag 34)))
					(not (SetFlag 25))
				)
				(= global211 (= global212 1))
				(proc63002_7 3321 6230)
			else
				(= global209 3321)
				(gCurRoom newRoom: 3131) ; networkRoomCH1SR3
			)
		)
	)
)

(instance paulsDoorFeature of P2Feature
	(properties
		scene 3322
	)
)

(instance usedKeyFea of ExitFeature
	(properties
		readyFlag 11
		nextRoom 3311
		exitScene 3340
	)

	(method (init)
		(if (super init:)
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 64 0 135 7 150 336 86 335))
			(return 1)
		)
	)
)

(instance officeDoorFea of P2Feature
	(properties
		nextRoom 3001
	)

	(method (init)
		(if (super init:)
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 64 0 135 7 150 336 86 335))
			(return 1)
		)
	)
)

(instance sensorFeature of P2Feature
	(properties)
)

(instance sensorCode of Code
	(properties)

	(method (doit)
		(if (or (IsFlag 11) (== gVerb 6)) ; cardKeyI
			(= global209 3340)
			(SetFlag 11)
			(gCurRoom newRoom: 3311) ; mainOfficeRoomCH1SR1
		else
			(gCurRoom newRoom: 3001) ; doorCloseupRoom
		)
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

