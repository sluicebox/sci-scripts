;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7006)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Timer)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)

(public
	dreamingTreeRoomENDGAME 0
)

(instance dreamingTreeRoomENDGAME of P2Room
	(properties
		picture 990
	)

	(method (init)
		(super init: &rest)
		(chair init:)
		(isThatAGunInYourPocket init:)
		(gP2SongPlyr start: 7960)
		(exitFeat init:)
		(jossF init:)
		(gunF init:)
		(jocTimer init:)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(jocTimer dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 3006) ; mainHallRoomENDGAME
			(gP2SongPlyr fadeOut: 0)
		)
	)
)

(instance exitFeat of ExitFeature
	(properties
		priority 10
		nextRoom 999
		exitDir 7
		exitScene 9540
	)

	(method (init)
		(super init: 140 4 266 180)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(jocTimer dispose:)
		)
	)
)

(instance jossF of ExitFeature
	(properties
		priority 20
		nextRoom 999
		exitScene 9530
	)

	(method (init)
		(super init: 244 73 305 208)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(jocTimer dispose:)
		)
	)
)

(instance gunF of ExitFeature
	(properties
		priority 50
		nextRoom 3006
		exitScene 4950
	)

	(method (init)
		(super init: (proc63002_10 293 153 312 110 332 111 316 172))
	)

	(method (onMe)
		(if (super onMe: &rest)
			(if
				(or
					(<= 0 (isThatAGunInYourPocket cel:) 15)
					(<= 43 (isThatAGunInYourPocket cel:) 58)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(jocTimer dispose:)
		)
	)
)

(instance jocTimer of P2Timer
	(properties)

	(method (init)
		(self start: 3 14)
	)

	(method (cue)
		(= global209 9540)
		(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
	)
)

(instance isThatAGunInYourPocket of P2Fidget
	(properties
		x 229
		y 224
		view 19900
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 0
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance chair of View
	(properties
		x 229
		y 224
		view 19900
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

