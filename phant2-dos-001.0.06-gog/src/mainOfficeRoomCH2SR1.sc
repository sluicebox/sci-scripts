;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3312)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	mainOfficeRoomCH2SR1 0
)

(local
	[local0 4] = [80 30 280 334]
	[local4 4] = [281 48 370 270]
	[local8 4] = [512 48 525 284]
	[local12 4] = [528 94 552 143]
	local16 = 5
)

(instance mainOfficeRoomCH2SR1 of P2Room
	(properties
		picture 170
		north 3332
		south 3362
		east 3322
	)

	(method (init)
		(curtis init:)
		(ear init: [local12 0] [local12 1] [local12 2] [local12 3])
		(if (and (IsFlag 228) (not (gRoboGary isPlaying:)))
			(gRoboGary
				setScore: 4 (if (IsFlag 227) 3022 else 3021) 2 8 12 3
				start:
			)
		)
		(super init: &rest)
		(jossOrTomCubeFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtOrTrevCubeFeature
			init: [local4 0] [local4 1] [local4 2] [local4 3]
		)
		(bobOrThereseCubeFeature
			init: [local8 0] [local8 1] [local8 2] [local8 3]
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
		(if (not (-- local16))
			(eggAMatic add: gCurRoomNum 1 4)
			(= local16 5)
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
		nextRoom 3352
		exitDir 5
	)
)

(instance curtOrTrevCubeFeature of P2Feature
	(properties
		nextRoom 3332
		exitDir 7
	)
)

(instance bobOrThereseCubeFeature of P2Feature
	(properties
		nextRoom 3342
		exitDir 1
	)
)

