;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3321)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)
(use System)

(public
	mainOfficeRoomCH1SR2 0
)

(local
	[local0 4] = [62 17 160 213]
	[local4 4] = [417 40 560 330]
	[local8 4] = [44 230 90 330]
)

(instance mainOfficeRoomCH1SR2 of P2Room
	(properties
		picture 180
		north 3361
		south 3331
		west 3341
	)

	(method (init)
		(super init: &rest)
		(cond
			((and (IsFlag 46) (not (IsFlag 45)))
				(if (not (gRoboGary isPlaying:))
					(gRoboGary setScore: 4 3013 2 10 20 3 start:)
				)
			)
			((OneOf gPrevRoomNum 4611 4621 4631 4641 4650) ; paulsOfficeRoomCH1SR1, paulsOfficeRoomCH1SR2, paulsOfficeRoomCH1SR3, paulsOfficeRoomCH1SR4, paulsOfficeRoomSR5
				(gP2SongPlyr
					fadeOut: 0
					fadeIn:
						(cond
							((IsFlag 45) 3014)
							((IsFlag 26) 3012)
							(else 3011)
						)
						100
				)
			)
		)
		(((ScriptID 63000 0) target:) ; nExit
			setRect:
				215
				(((ScriptID 63000 0) target:) top:) ; nExit
				413
				(((ScriptID 63000 0) target:) bottom:) ; nExit
		)
		(or
			(paulsOpenDoorFeature init:)
			(paulsClosedDoorFeature
				init: [local0 0] [local0 1] [local0 2] [local0 3]
			)
		)
		(jossOrTomFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(curtis init:)
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

(instance paulsClosedDoorFeature of P2Feature
	(properties
		scene 3411
		doneFlag 6
	)
)

(instance paulsOpenDoorFeature of P2View
	(properties
		x 55
		y 242
		view 180
		readyFlag 5
		nextRoom 4631
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(= global209 (if (SetFlag 111) 3886 else 4390))
		)
	)
)

(instance jossOrTomFeature of P2Feature
	(properties
		nextRoom 3351
		exitDir 1
	)
)

(instance firstWaterCoolerFeature of P2Feature
	(properties
		scene 3390
		doneFlag 1
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
		scene 3920
		sceneScored 1
		readyFlag 37
		doneFlag 2
	)

	(method (init)
		(if (not (IsFlag 70))
			(super init: &rest)
		else
			(return 0)
		)
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
		doneFlag 3
	)

	(method (handleEvent)
		(super handleEvent: &rest)
	)
)

