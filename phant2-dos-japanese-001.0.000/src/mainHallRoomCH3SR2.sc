;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3023)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)

(public
	mainHallRoomCH3SR2 0
)

(instance mainHallRoomCH3SR2 of P2Room
	(properties
		picture 110
		south 3063
	)

	(method (init)
		(curtis init:)
		(super init: &rest)
		(sensorFeature init: (proc63002_10 530 216 548 223 546 264 529 257))
		(sensorFeature addVerb: 6 delVerb: 4)
		(gGame handsOn: 1)
	)
)

(instance sensorFeature of ExitFeature
	(properties
		nextRoom 3063
		exitScene 3327
	)
)

(instance curtis of P2Fidget
	(properties
		x 87
		y 336
		view 11100
		wiggler 1
		zone1aLeft 0
		zone1aRight 1
		zone1bLeft 1
		zone1bRight 2
		zone2aLeft 2
		zone2aRight 7
		zone2bLeft 7
		zone2bRight 13
	)
)

