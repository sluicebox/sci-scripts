;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3333)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use ExitFeature)

(public
	mainOfficeRoomCH3SR3 0
)

(local
	[local0 4] = [450 30 550 297]
	[local4 4] = [72 0 290 297]
)

(instance mainOfficeRoomCH3SR3 of P2Room
	(properties
		picture 190
		south 3323
		east 3343
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 100)
		(= global241 100)
		(super init: &rest)
		(trevCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(or
			(firstCurtCube init: [local4 0] [local4 1] [local4 2] [local4 3])
			(curtCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		)
		(gGame handsOn: 1)
	)
)

(instance trevCubeFeature of P2Feature
	(properties
		nextRoom 4103
		exitDir 1
	)
)

(instance firstCurtCube of ExitFeature
	(properties
		doneFlag 376
		nextRoom 4013
		exitDir 7
		exitScene 5890
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(= global211 1)
		)
	)
)

(instance curtCubeFeature of P2Feature
	(properties
		nextRoom 4013
		exitDir 7
	)
)

