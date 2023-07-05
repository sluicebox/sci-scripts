;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3035)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)

(public
	mainHallRoomCH5SR3 0
)

(local
	[local0 4] = [260 192 292 224]
)

(instance mainHallRoomCH5SR3 of P2Room
	(properties
		picture 700
		south 3045
	)

	(method (init)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 3051)
		(curtis init:)
		(ClearFlag 1001)
		(sensorFeature
			init: [local0 0] [local0 1] [local0 2] [local0 3]
			delVerb: 4
			addVerb: 6 36
		)
		(gGame handsOn: 1)
	)
)

(instance sensorFeature of ExitFeature
	(properties
		nextRoom 3414
	)
)

(instance curtis of P2Fidget
	(properties
		x 109
		y 335
		view 17000
		initStart 0
		initFinish 2
		cycleStart 8
		cycleFinish 16
	)
)

