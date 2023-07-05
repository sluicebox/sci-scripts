;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3332)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)

(public
	mainOfficeRoomCH2SR3 0
)

(local
	[local0 4] = [450 30 550 297]
	[local4 4] = [72 0 290 297]
)

(instance mainOfficeRoomCH2SR3 of P2Room
	(properties
		picture 190
		south 3322
		east 3342
	)

	(method (init)
		(if (and (IsFlag 228) (not (gRoboGary isPlaying:)))
			(gRoboGary
				setScore: 4 (if (IsFlag 227) 3022 else 3021) 2 8 12 3
				start:
			)
		)
		(super init: &rest)
		(trevCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(or
			(firstCurtCubeFeature
				init: [local4 0] [local4 1] [local4 2] [local4 3]
			)
			(lastCurtCubeFeature
				init: [local4 0] [local4 1] [local4 2] [local4 3]
			)
			(secondCurtCubeFeature
				init: [local4 0] [local4 1] [local4 2] [local4 3]
			)
		)
		(gGame handsOn: 1)
	)
)

(instance trevCubeFeature of P2Feature
	(properties
		nextRoom 4102
		exitDir 1
	)
)

(instance firstCurtCubeFeature of ExitFeature
	(properties
		doneFlag 231
		nextRoom 3012
		exitDir 7
		exitScene 5830
	)

	(method (handleEvent)
		(or
			(lastCurtCubeFeature
				init: [local4 0] [local4 1] [local4 2] [local4 3]
			)
			(secondCurtCubeFeature
				init: [local4 0] [local4 1] [local4 2] [local4 3]
			)
		)
		(super handleEvent: &rest)
	)
)

(instance lastCurtCubeFeature of ExitFeature
	(properties
		readyFlag 248
		nextRoom 3012
		exitDir 7
		exitScene 5850
	)
)

(instance secondCurtCubeFeature of ExitFeature
	(properties
		scene 5860
		readyFlag 231
		nextRoom 3012
		exitDir 7
	)
)

