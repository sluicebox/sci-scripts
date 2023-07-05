;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6114)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use DialogEditor)

(public
	blEntranceHallCH4SR1 0
)

(local
	[local0 6] = [119 104 105 112 109 101]
	local6
)

(instance blEntranceHallCH4SR1 of P2Room
	(properties
		picture 640
		south 6214
	)

	(method (init)
		(if (not (IsFlag 581))
			((gUser primaDonnas:) add: wMe)
		)
		(groanFeat init:)
		(if (or (not (IsFlag 542)) (proc63002_4 542 545))
			(exitDoor init:)
		)
		(fidget init:)
		(super init: &rest)
		(gP2SongPlyr fadeTo: 80)
		(gGame handsOn: 1)
	)

	(method (dispose)
		((gUser primaDonnas:) delete: wMe)
		(super dispose: &rest)
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

(instance groanFeat of P2Feature
	(properties
		scene 8180
		fadeToVol 55
	)

	(method (init)
		(super init: (proc63002_10 146 7 343 21 343 295 150 295))
	)
)

(instance wMe of EventHandler
	(properties)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evKEYBOARD)
					(or
						(== (event message:) [local0 local6])
						(== (+ (event message:) KEY_SPACE) [local0 local6])
					)
				)
				(if (== local6 5)
					(= local6 0)
					(gP2SoundFX play: 6800)
					(eggAMatic add: 6114 1 15)
					(SetFlag 581)
					((gUser primaDonnas:) delete: wMe)
				else
					(++ local6)
				)
				(event claimed: 1)
			)
			((& (event type:) evKEYBOARD)
				(= local6 0)
			)
		)
		(event claimed:)
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

