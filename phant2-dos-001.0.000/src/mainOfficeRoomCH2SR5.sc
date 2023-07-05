;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3352)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)

(public
	mainOfficeRoomCH2SR5 0
)

(local
	[local0 4] = [115 0 360 330]
	[local4 4] = [350 35 580 330]
)

(instance mainOfficeRoomCH2SR5 of P2Room
	(properties
		picture 210
		east 3312
		west 3362
	)

	(method (init)
		(if (and (IsFlag 228) (not (gRoboGary isPlaying:)))
			(gRoboGary
				setScore: 4 (if (IsFlag 227) 3022 else 3021) 2 8 12 3
				start:
			)
		)
		(super init: &rest)
		(tomCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(jossCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance tomCubeFeature of P2Feature
	(properties
		nextRoom 4502
		exitDir 7
	)
)

(instance jossCubeFeature of P2Feature
	(properties
		nextRoom 4402
		exitDir 1
	)
)

