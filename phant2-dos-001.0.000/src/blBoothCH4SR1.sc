;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6314)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	blBoothCH4SR1 0
)

(local
	local0
)

(instance blBoothCH4SR1 of P2Room
	(properties
		picture 470
		south 6214
	)

	(method (init)
		(if (not (IsFlag 542))
			(ClearFlag 1001)
			(= global209 8110)
			(SetFlag 542)
		)
		(if (not (IsFlag 545))
			(thereseFeature init:)
			(thereseFidget init:)
			(fidget init:)
			(if (IsFlag 543)
				(drink2 init:)
				(drinkFeat init:)
			else
				(drink1 init:)
			)
		else
			(curtisOTS init:)
		)
		(gP2SongPlyr fadeTo: 75)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance convoCode of Code
	(properties)

	(method (doit)
		(cond
			((not (IsFlag 543))
				(proc63002_7 8130)
				(SetFlag 543)
				(drink1 dispose:)
				(drink2 init:)
				(drinkFeat init:)
			)
			((not (IsFlag 544))
				(proc63002_7 8150)
				(SetFlag 544)
				(thereseFeature dispose:)
			)
		)
	)
)

(instance thereseFidget of P2Fidget
	(properties
		x 223
		y 254
		view 14703
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
		(if (IsFlag 544)
			(return 0)
		else
			(= whoDoit convoCode)
			(super init: 259 63 313 169)
		)
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

(instance drink1 of View
	(properties
		x 325
		y 185
		view 470
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance drink2 of View
	(properties
		x 325
		y 185
		view 470
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
		(self setPri: 20)
	)
)

(instance drinkFeat of P2Feature
	(properties
		scene 8185
		doneFlag 545
		nextRoom 6214
	)

	(method (init)
		(super init: 377 150 390 172)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(SetFlag 1001)
		)
		(event claimed:)
	)
)

(instance curtisOTS of View
	(properties
		x 390
		y 335
		view 14701
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

