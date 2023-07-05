;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3351)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH1SR5 0
)

(local
	[local0 4] = [115 0 360 330]
	[local4 4] = [350 35 580 330]
)

(instance mainOfficeRoomCH1SR5 of P2Room
	(properties
		picture 210
		east 3311
		west 3361
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 100)
		(= global241 100)
		(super init: &rest)
		(tomCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(jossCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance tomCubeFeature of ExitFeature
	(properties
		nextRoom 4501
		exitDir 7
	)
)

(instance jossCubeFeature of ExitFeature
	(properties
		nextRoom 4401
		exitDir 1
	)
)

