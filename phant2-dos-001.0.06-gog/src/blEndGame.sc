;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6406)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Timer)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)

(public
	blEndGame 0
)

(instance blEndGame of P2Room
	(properties
		picture 1000
		style 0
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(ohMyHeavenlyGod init:)
		(theRack init:)
		(theLever init:)
		(levelFeat init:)
		(thereseFeat init:)
		(gP2SongPlyr fadeIn: 6960)
		(thereseTimer init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(thereseTimer dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 6506) ; backYard
			(gP2SongPlyr fadeOut: 0)
		)
	)
)

(instance ohMyHeavenlyGod of P2Fidget
	(properties
		x 107
		y 274
		view 10000
		cycleSpeed 7
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

(instance theRack of View
	(properties
		x 107
		y 275
		view 10000
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance theLever of View
	(properties
		x 120
		y 244
		view 1000
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance levelFeat of ExitFeature
	(properties
		doneFlag 1505
		nextRoom 6506
		exitScene 5003
	)

	(method (init)
		(super init: 139 164 178 216)
	)
)

(instance thereseFeat of ExitFeature
	(properties
		nextRoom 999
		exitScene 5002
	)

	(method (init)
		(super init: 261 37 357 194)
	)
)

(instance thereseTimer of P2Timer
	(properties)

	(method (init)
		(self start: 3 7)
	)

	(method (cue)
		(= global209 5001)
		(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
	)
)

