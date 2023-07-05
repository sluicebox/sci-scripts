;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6112)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)

(public
	blEntranceHallCH2SR1 0
)

(instance blEntranceHallCH2SR1 of P2Room
	(properties
		picture 640
		south 6212
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 218))
			(exitDoor init:)
		)
		(bathRoom init:)
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

(instance bathRoom of P2Feature
	(properties)

	(method (init)
		(= fadeToVol 55)
		(if (== global207 1)
			(= doneFlag 267)
			(= scene 7785)
		else
			(= doneFlag 214)
			(= scene 7780)
		)
		(super init: (proc63002_10 146 7 343 21 343 295 150 295))
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

