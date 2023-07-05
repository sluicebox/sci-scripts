;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3335)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH5SR3 0
)

(local
	[local0 4] = [450 30 550 297]
	[local4 4] = [72 0 290 297]
)

(instance mainOfficeRoomCH5SR3 of P2Room
	(properties
		picture 190
		south 3325
		east 3345
	)

	(method (init)
		(super init: &rest)
		(trevCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance trevCubeFeature of ExitFeature
	(properties
		nextRoom 4105
		exitDir 1
	)
)

(instance curtCubeFeature of ExitFeature
	(properties
		nextRoom 4015
		exitDir 7
	)
)

