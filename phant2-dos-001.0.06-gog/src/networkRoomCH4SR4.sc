;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3144)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)

(public
	networkRoomCH4SR4 0
)

(local
	[local0 4] = [278 42 396 246]
)

(instance networkRoomCH4SR4 of P2Room
	(properties
		picture 161
		south 3134
	)

	(method (init)
		(super init: &rest)
		(littleDoorFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance littleDoorFeature of P2Feature
	(properties
		scene 6270
		doneFlag 318
	)
)

