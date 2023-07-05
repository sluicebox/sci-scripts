;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6214)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use Feature)

(public
	blDanceCH4SR1 0
)

(instance blDanceCH4SR1 of P2Room
	(properties
		picture 450
	)

	(method (init)
		(super init: &rest)
		(entranceArea init:)
		(backDoorArea init:)
		(boothArea init:)
		(if (IsFlag 541)
			(fidget init:)
			(if (Random 0 1)
				(brett init:)
			)
			(speed init:)
		else
			(patron3Fidget init:)
			(whipMe init:)
			(staticCurtis init:)
		)
		(if (Random 0 1)
			(extras1 init:)
		else
			(extras2 init:)
		)
		(if (and (gP2SongPlyr isPlaying:) (== (gP2SongPlyr number:) 6940))
			(gP2SongPlyr fadeTo: 100)
		else
			(gP2SongPlyr fadeIn: 6940)
		)
		(gGame handsOn: 1)
	)
)

(instance whipMe of P2Feature
	(properties
		scene 8100
		fadeToVol 75
		doneFlag 541
	)

	(method (init)
		(super init: 127 115 168 259)
	)
)

(instance entranceArea of P2Feature
	(properties
		nextRoom 6114
		exitDir 7
	)

	(method (init)
		(super init: (proc63002_10 350 75 397 76 398 167 348 190))
	)
)

(instance backDoorArea of P2Feature
	(properties
		nextRoom 6414
		exitDir 1
	)

	(method (init)
		(super init: 572 74 628 169)
	)
)

(instance boothArea of ExitFeature
	(properties
		nextRoom 6314
		exitDir 6
	)

	(method (init)
		(super init: 2 68 40 288)
	)
)

(instance fidget of P2Fidget
	(properties
		y 335
		view 14500
		wiggler 1
		delay 1
		zone1aLeft 15
		zone1aRight 13
		zone1bLeft 12
		zone1bRight 10
		zone2aLeft 9
		zone2aRight 5
		zone2bLeft 4
		zone2bRight 1
		origin 100
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

(instance staticCurtis of View
	(properties
		y 335
		view 14500
	)

	(method (init)
		(super init: &rest)
		(self setPri: 5)
	)
)

(instance patron3Fidget of P2Fidget
	(properties
		x 121
		y 262
		view 14503
		initStart 2
		initFinish 3
		cycleFinish 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance brett of P2Fidget
	(properties
		x 169
		y 267
		view 14504
		initStart 2
		initFinish 3
		cycleFinish 8
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance extras1 of P2Fidget
	(properties
		x 422
		y 212
		view 14505
		initFinish 6
		cycleStart 3
		cycleFinish 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance extras2 of P2Fidget
	(properties
		x 353
		y 218
		view 14506
		initFinish 7
		cycleFinish 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance speed of Feature
	(properties)

	(method (init)
		(super init: gThePlane 50 232 86 238 98)
	)

	(method (handleEvent event)
		(if (and (== gVerb 4) (& (event type:) evMOUSEBUTTON)) ; Do
			(event claimed: 1)
			(fidget delay: 0)
			(fidget cycleSpeed: 0)
		)
	)
)

