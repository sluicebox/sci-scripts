;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3313)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use P2Fidget)
(use Feature)

(public
	mainOfficeRoomCH3SR1 0
)

(local
	[local0 4] = [80 30 280 334]
	[local4 4] = [281 48 370 270]
	[local8 4] = [512 48 525 284]
	[local12 4] = [542 111 601 317]
)

(instance mainOfficeRoomCH3SR1 of P2Room
	(properties
		picture 170
		north 3333
		south 3363
		east 3323
	)

	(method (init)
		(curtis init:)
		(super init: &rest)
		(jossOrTomCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtOrTrevCubeFeature
			init: [local4 0] [local4 1] [local4 2] [local4 3]
		)
		(bobOrThereseCubeFeature
			init: [local8 0] [local8 1] [local8 2] [local8 3]
		)
		(or
			(firstWaterCoolerFeature
				init: [local12 0] [local12 1] [local12 2] [local12 3]
			)
			(secondWaterCoolerFeature
				init: [local12 0] [local12 1] [local12 2] [local12 3]
			)
			(thirdWaterCoolerFeature
				init: [local12 0] [local12 1] [local12 2] [local12 3]
			)
		)
		(tummy init: gThePlane 1 420 142 430 152)
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 377
		y 327
		view 11700
		initStart 0
		initFinish 0
		cycleStart 7
	)
)

(instance tummy of Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (& (event modifiers:) emALT))
			(gCurRoom newRoom: 3310) ; aRoom
		)
	)
)

(instance jossOrTomCubeFeature of P2Feature
	(properties
		nextRoom 3353
		exitDir 5
	)
)

(instance curtOrTrevCubeFeature of P2Feature
	(properties
		nextRoom 3333
		exitDir 7
	)
)

(instance bobOrThereseCubeFeature of P2Feature
	(properties
		nextRoom 3343
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
				init: [local12 0] [local12 1] [local12 2] [local12 3]
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
				init: [local12 0] [local12 1] [local12 2] [local12 3]
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

