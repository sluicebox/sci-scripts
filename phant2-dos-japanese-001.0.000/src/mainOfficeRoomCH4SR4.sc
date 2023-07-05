;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3344)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH4SR4 0
)

(local
	[local0 4] = [280 20 475 330]
	[local4 4] = [220 40 279 330]
)

(instance mainOfficeRoomCH4SR4 of P2Room
	(properties
		picture 201
		east 3324
		west 3334
	)

	(method (init)
		(super init: &rest)
		(bobCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(thereseCubeFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance bobCubeFeature of ExitFeature
	(properties
		nextRoom 4304
		exitDir 1
	)
)

(instance thereseCubeFeature of ExitFeature
	(properties
		nextRoom 4204
		exitDir 7
	)
)

