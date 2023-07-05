;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6412)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use P2Fidget)

(public
	blBackRoomCH2SR1 0
)

(instance blBackRoomCH2SR1 of P2Room
	(properties
		picture 461
		south 6212
	)

	(method (init)
		(super init: &rest)
		(bouncer init:)
		(backDoor init:)
		(gP2SongPlyr fadeTo: 75)
		(gGame handsOn: 1)
	)
)

(instance backDoor of P2Feature
	(properties
		priority 50
		scene 7800
		doneFlag 215
		exitDir 0
	)

	(method (init)
		(super init: 373 42 477 216)
	)
)

(instance bouncer of P2Fidget
	(properties
		x 467
		y 331
		view 14601
		initStart 2
		initFinish 3
		cycleStart 5
		cycleFinish 9
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

