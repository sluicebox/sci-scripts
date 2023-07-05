;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6312)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	blBoothCH2SR1 0
)

(local
	[local0 3] = [0 192 110]
)

(instance blBoothCH2SR1 of P2Room
	(properties
		picture 470
		south 6212
	)

	(method (init)
		(if (IsFlag 260)
			(drinkView init:)
			(drinkFeat init:)
		else
			(theDrinks init:)
			(thereseFeature init:)
		)
		(fidget init:)
		(thereseFidget init:)
		(gP2SongPlyr fadeTo: 75)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance convoCode of Code
	(properties)

	(method (doit)
		(cond
			((not (IsFlag 258))
				(proc63002_7 7830)
				(SetFlag 258)
			)
			((not (IsFlag 259))
				(proc63002_7 7850)
				(SetFlag 259)
			)
			(else
				(thereseFeature dispose:)
				(proc63002_7 7870)
				(SetFlag 260)
				(theDrinks dispose:)
				(drinkView init:)
				(drinkFeat init:)
			)
		)
	)
)

(instance drinkFeat of P2Feature
	(properties
		scene 7920
		nextRoom 6322
	)

	(method (init)
		(super init: 377 150 390 172)
	)
)

(instance drinkView of View
	(properties
		x 313
		y 195
		view 470
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance theDrinks of View
	(properties
		priority 20
		x 299
		y 201
		view 470
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance thereseFidget of P2Fidget
	(properties
		x 246
		y 250
		view 14702
		cycleSpeed 5
		initStart 2
		initFinish 5
		cycleStart 7
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance thereseFeature of P2Feature
	(properties
		priority 50
	)

	(method (init)
		(= whoDoit convoCode)
		(super init: 259 63 313 169)
	)
)

(instance fidget of P2Fidget
	(properties
		x 349
		y 246
		view 14700
		cycleSpeed 7
		wiggler 1
		delay 1
		zone1aLeft 0
		zone1aRight 3
		zone1bLeft 4
		zone1bRight 14
		zone2aLeft 15
		zone2aRight 20
		zone2bLeft 21
		zone2bRight 29
		origin 406
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

