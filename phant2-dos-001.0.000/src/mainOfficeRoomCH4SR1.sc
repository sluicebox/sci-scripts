;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3314)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	mainOfficeRoomCH4SR1 0
)

(local
	[local0 4] = [80 30 280 334]
	[local4 4] = [281 48 370 270]
	[local8 4] = [512 48 525 284]
	[local12 4] = [542 111 601 317]
	[local16 4] = [528 94 552 143]
	local20 = 5
)

(instance mainOfficeRoomCH4SR1 of P2Room
	(properties
		picture 170
		north 3334
		south 3364
		east 3324
	)

	(method (init)
		(super init: &rest)
		(ear init: [local16 0] [local16 1] [local16 2] [local16 3])
		(curtis init:)
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
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 370
		y 335
		view 11701
		wiggler 1
		delay 1
		zone1aLeft 8
		zone1aRight 7
		zone1bLeft 6
		zone1bRight 5
		zone2aLeft 4
		zone2aRight 2
		zone2bLeft 1
		zone2bRight 0
	)
)

(instance ear of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self isHot: 0 whoDoit: flickEar)
		(((gThePlane cast:) eventList:) add: self)
	)
)

(instance flickEar of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if (not (-- local20))
			(eggAMatic add: gCurRoomNum 1 4)
			(= local20 5)
			(gP2SoundFX play: 3312)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(curtis setCel: (* 8 (mod temp0 2)) update:)
				(FrameOut)
				(for ((= temp1 0)) (< temp1 2) ((++ temp1))
					(= temp2 (GetTime))
					(while (== temp2 (GetTime))
					)
				)
			)
		)
	)
)

(instance jossOrTomCubeFeature of P2Feature
	(properties
		nextRoom 3354
		exitDir 5
	)
)

(instance curtOrTrevCubeFeature of P2Feature
	(properties
		nextRoom 3334
		exitDir 7
	)
)

(instance bobOrThereseCubeFeature of P2Feature
	(properties
		nextRoom 3344
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
				init: [local12 0] [local12 1] [local12 2] [local12 3]
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
				init: [local12 0] [local12 1] [local12 2] [local12 3]
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

