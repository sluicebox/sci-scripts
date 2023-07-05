;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3363)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	mainOfficeRoomCH3SR6 0
)

(local
	[local0 4] = [200 0 335 280]
)

(instance mainOfficeRoomCH3SR6 of P2Room
	(properties
		picture 220
		south 3313
	)

	(method (init)
		(super init: &rest)
		(exitDoorFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance exitDoorFeature of ExitFeature
	(properties
		nextRoom 3013
		exitScene 3418
	)
)

