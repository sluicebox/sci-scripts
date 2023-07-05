;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3342)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)

(public
	mainOfficeRoomCH2SR4 0
)

(local
	[local0 4] = [280 20 475 330]
	[local4 4] = [220 40 279 330]
)

(instance mainOfficeRoomCH2SR4 of P2Room
	(properties
		picture 201
		east 3322
		west 3332
	)

	(method (init)
		(if (and (IsFlag 228) (not (gRoboGary isPlaying:)))
			(gRoboGary
				setScore: 4 (if (IsFlag 227) 3022 else 3021) 2 8 12 3
				start:
			)
		)
		(super init: &rest)
		(bobCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(thereseCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance bobCubeFeature of P2Feature
	(properties
		nextRoom 4302
		exitDir 1
	)
)

(instance thereseCubeFeature of P2Feature
	(properties
		nextRoom 4202
		exitDir 7
	)
)

