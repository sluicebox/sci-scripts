;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6113)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)

(public
	blEntranceHallCH3SR1 0
)

(instance blEntranceHallCH3SR1 of P2Room
	(properties
		picture 640
		south 6213
	)

	(method (init)
		(super init: &rest)
		(exitDoor init:)
		(closed init:)
		(fidget init:)
		(gP2SongPlyr fadeTo: 80)
		(gGame handsOn:)
	)
)

(instance exitDoor of ExitFeature
	(properties
		nextRoom 900
		exitDir 0
		exitScene 7692
	)

	(method (init)
		(super init: (proc63002_10 509 29 590 33 583 245 505 245))
	)
)

(instance closed of View
	(properties
		x 206
		y 181
		view 640
	)
)

(instance fidget of P2Fidget
	(properties
		y 335
		view 16400
		wiggler 1
		delay 1
		zone1aLeft 0
		zone1aRight 1
		zone1bLeft 2
		zone1bRight 3
		zone2aLeft 4
		zone2aRight 10
		zone2bLeft 11
		zone2bRight 16
		origin 30
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

