;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3323)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)

(public
	mainOfficeRoomCH3SR2 0
)

(local
	[local0 4] = [62 17 160 213]
	[local4 4] = [417 40 560 330]
	[local8 4] = [44 230 90 330]
)

(instance mainOfficeRoomCH3SR2 of P2Room
	(properties
		picture 180
		north 3363
		south 3333
		west 3343
	)

	(method (init)
		(if (proc63002_4 399 400 376 395 326 408 409 410)
			(SetFlag 324)
		)
		(super init: &rest)
		(or
			(tomPaulsDoorFeature init:)
			(alliePaulsDoorFeature
				init: [local0 0] [local0 1] [local0 2] [local0 3]
			)
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

(instance tomPaulsDoorFeature of P2View
	(properties
		x 55
		y 242
		view 180
		readyFlag 324
		nextRoom 1013
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(gRoboGary stop: 1)
			(= global211 1)
			(= global212 0)
			(= global209 4730)
		)
	)
)

(instance alliePaulsDoorFeature of P2Feature
	(properties
		scene 4720
		readyFlag 325
		doneFlag 326
	)
)

(instance jossOrTomFeature of P2Feature
	(properties
		nextRoom 3353
		exitDir 1
	)
)

(instance firstWaterCoolerFeature of P2Feature
	(properties
		scene 3390
		doneFlag 320
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
		doneFlag 321
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
		doneFlag 323
	)

	(method (handleEvent)
		(super handleEvent: &rest)
	)
)

