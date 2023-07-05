;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6013)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)

(public
	blEntranceCH3SR1 0
)

(instance blEntranceCH3SR1 of P2Room
	(properties
		south 900
	)

	(method (init)
		((ScriptID 63000 1) exitScene: 7691) ; sExit
		(bouncerFidget init:)
		(bike init:)
		(fidget init:)
		(doorFeat init:)
		(= picture 440)
		(super init: &rest)
		(gP2SongPlyr start: 6910)
		(gGame handsOn: 1)
	)
)

(instance doorFeat of ExitFeature
	(properties
		nextRoom 6213
		exitDir 1
	)

	(method (init)
		(= exitScene (Random 7735 7736))
		(super init: (proc63002_10 399 9 461 20 456 234 401 243))
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gP2SongPlyr stop:)
		)
		(event claimed:)
	)
)

(instance bike of View
	(properties
		x 105
		y 278
		view 440
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance fidget of P2Fidget
	(properties
		x 187
		y 338
		view 14400
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 8
		zone1aRight 10
		zone1bLeft 11
		zone1bRight 19
		zone2aLeft 20
		zone2aRight 25
		zone2bLeft 26
		zone2bRight 30
	)

	(method (init)
		(super init:)
		(self setPri: 30)
	)
)

(instance bouncerFidget of P2Fidget
	(properties
		x 335
		y 308
		view 14401
		initStart 2
		initFinish 3
		cycleFinish 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance closedFidget of P2Fidget ; UNUSED
	(properties
		x 186
		y 339
		view 14402
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 8
		zone1aRight 10
		zone1bLeft 11
		zone1bRight 19
		zone2aLeft 20
		zone2aRight 25
		zone2bLeft 26
		zone2bRight 30
	)

	(method (init)
		(super init:)
		(self setPri: 30)
	)
)

