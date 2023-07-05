;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3354)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH4SR5 0
)

(local
	[local0 4] = [115 0 360 330]
	[local4 4] = [350 35 580 330]
)

(instance mainOfficeRoomCH4SR5 of P2Room
	(properties
		picture 210
		east 3314
		west 3364
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
		doneFlag 573
		nextRoom 3014
		exitDir 7
		exitScene 4820
	)
)

(instance jossCubeFeature of ExitFeature
	(properties
		nextRoom 4404
		exitDir 1
	)
)

