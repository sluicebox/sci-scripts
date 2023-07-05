;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3324)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	mainOfficeRoomCH4SR2 0
)

(local
	[local0 4] = [62 17 160 213]
	[local4 4] = [417 40 560 330]
	[local8 4] = [44 230 90 330]
)

(instance mainOfficeRoomCH4SR2 of P2Room
	(properties
		picture 180
		north 3364
		south 3334
		west 3344
	)

	(method (init)
		(gP2SongPlyr fadeIn: (if (IsFlag 521) 3041 else 3042))
		(super init: &rest)
		(paulsDoorFeature
			init: [local0 0] [local0 1] [local0 2] [local0 3]
			whoDoit: paulsDoorCode
		)
		(jossOrTomFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(or
			(firstWaterCoolerFeature
				init: [local8 0] [local8 1] [local8 2] [local8 3]
			)
			(secondWaterCoolerFeature
				init: [local8 0] [local8 1] [local8 2] [local8 3]
			)
			(thirdWaterCoolerFeature
				init: [local8 0] [local8 1] [local8 2] [local8 3]
			)
		)
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 325
		y 323
		view 11800
		initStart 0
		initFinish 0
		cycleStart 7
	)
)

(instance paulsDoorFeature of P2Feature
	(properties)
)

(instance paulsDoorCode of Code
	(properties)

	(method (doit)
		(if (not (SetFlag 527))
			(proc63002_7 4744)
		else
			(proc63002_7 4745)
		)
	)
)

(instance jossOrTomFeature of P2Feature
	(properties
		nextRoom 3354
		exitDir 1
	)
)

(instance firstWaterCoolerFeature of P2Feature
	(properties
		scene 3390
		doneFlag 524
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(secondWaterCoolerFeature
				init: [local8 0] [local8 1] [local8 2] [local8 3]
			)
		)
	)
)

(instance secondWaterCoolerFeature of P2Feature
	(properties
		scene 3390
		doneFlag 525
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(thirdWaterCoolerFeature
				init: [local8 0] [local8 1] [local8 2] [local8 3]
			)
		)
	)
)

(instance thirdWaterCoolerFeature of P2Feature
	(properties
		scene 3390
		doneFlag 526
	)

	(method (handleEvent)
		(super handleEvent: &rest)
	)
)

