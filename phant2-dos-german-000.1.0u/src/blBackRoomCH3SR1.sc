;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6413)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use P2Fidget)

(public
	blBackRoomCH3SR1 0
)

(instance blBackRoomCH3SR1 of P2Room
	(properties
		picture 460
		south 6213
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
		scene 8010
		doneFlag 342
		exitDir 0
	)

	(method (init)
		(super init: 224 32 397 220)
	)
)

(instance bouncer of P2Fidget
	(properties
		x 448
		y 338
		view 14603
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

