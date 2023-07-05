;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3025)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	mainHallRoomCH5SR2 0
)

(instance mainHallRoomCH5SR2 of P2Room
	(properties
		picture 110
		south 3065
	)

	(method (init)
		(curtis init:)
		(SetFlag 1001)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 3051)
		(sensorFeature init:)
		(gGame handsOn: 1)
	)
)

(instance sensorFeature of P2Feature
	(properties)

	(method (init)
		(if (super init:)
			(self
				addTarget: (proc63002_10 530 216 548 223 546 264 529 257) 0
				addVerb: 6
				addVerb: 36
				delVerb: 4
				whoDoit: sensorCode
			)
		)
	)
)

(instance sensorCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(6 ; cardKeyI
				(if (>= (& $0003 (>> global226 $0002)) 2)
					(= global209 3328)
					(gCurRoom newRoom: 3035) ; mainHallRoomCH5SR3
				else
					(= global209 3327)
					(gCurRoom newRoom: 3065) ; mainHallRoomCH5SR6
				)
			)
			(36 ; trevCardKeyI
				(if (>= (& $0003 (>> global226 $000a)) 2)
					(= global209 3328)
					(gCurRoom newRoom: 3035) ; mainHallRoomCH5SR3
				else
					(= global209 3327)
					(gCurRoom newRoom: 3065) ; mainHallRoomCH5SR6
				)
			)
		)
	)
)

(instance curtis of P2Fidget
	(properties
		x 87
		y 336
		view 11100
		wiggler 1
		zone1aLeft 0
		zone1aRight 2
		zone1bLeft 3
		zone1bRight 6
		zone2aLeft 7
		zone2aRight 10
		zone2bLeft 11
		zone2bRight 13
		origin 319
	)
)

