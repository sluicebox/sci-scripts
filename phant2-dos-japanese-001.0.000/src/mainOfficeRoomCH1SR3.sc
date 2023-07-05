;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3331)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH1SR3 0
)

(local
	[local0 4] = [450 30 550 297]
	[local4 4] = [72 0 290 297]
)

(instance mainOfficeRoomCH1SR3 of P2Room
	(properties
		picture 190
		south 3321
		east 3341
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 100)
		(= global241 100)
		(super init: &rest)
		(trevCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance trevCubeFeature of ExitFeature
	(properties
		nextRoom 4101
		exitDir 1
	)
)

(instance curtCubeFeature of ExitFeature
	(properties
		nextRoom 4011
		exitDir 7
	)
)

