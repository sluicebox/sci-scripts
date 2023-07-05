;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3334)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH4SR3 0
)

(local
	[local0 4] = [450 30 550 297]
)

(instance mainOfficeRoomCH4SR3 of P2Room
	(properties
		picture 190
		south 3324
		east 3344
	)

	(method (init)
		(super init: &rest)
		(trevCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance trevCubeFeature of ExitFeature
	(properties
		nextRoom 4104
		exitDir 1
	)
)

