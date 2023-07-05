;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3355)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH5SR5 0
)

(local
	[local0 4] = [115 0 360 330]
	[local4 4] = [350 35 580 330]
)

(instance mainOfficeRoomCH5SR5 of P2Room
	(properties
		picture 211
		east 3315
		west 3365
	)

	(method (init)
		(super init: &rest)
		(tomCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(jossCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance tomCubeFeature of ExitFeature
	(properties
		nextRoom 4505
		exitDir 7
	)
)

(instance jossCubeFeature of ExitFeature
	(properties
		nextRoom 4405
		exitDir 1
	)
)

