;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3341)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	mainOfficeRoomCH1SR4 0
)

(local
	[local0 4] = [280 20 475 330]
	[local4 4] = [220 40 279 330]
)

(instance mainOfficeRoomCH1SR4 of P2Room
	(properties
		east 3321
		west 3331
	)

	(method (init)
		(= picture (if (IsFlag 70) 201 else 200))
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 100)
		(= global241 100)
		(super init: &rest)
		(bobCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(thereseCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance bobCubeFeature of ExitFeature
	(properties
		nextRoom 4301
		exitDir 1
	)
)

(instance thereseCubeFeature of ExitFeature
	(properties
		nextRoom 4201
		exitDir 7
	)
)

