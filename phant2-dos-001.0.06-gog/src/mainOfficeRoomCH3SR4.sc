;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3343)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)

(public
	mainOfficeRoomCH3SR4 0
)

(local
	[local0 4] = [280 20 475 330]
	[local4 4] = [220 40 279 330]
)

(instance mainOfficeRoomCH3SR4 of P2Room
	(properties
		picture 201
		east 3323
		west 3333
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 100)
		(= global241 100)
		(super init: &rest)
		(bobCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(thereseCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance bobCubeFeature of P2Feature
	(properties
		nextRoom 4303
		exitDir 1
	)
)

(instance thereseCubeFeature of P2Feature
	(properties
		nextRoom 4203
		exitDir 7
	)
)

