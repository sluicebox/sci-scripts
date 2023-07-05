;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3325)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)

(public
	mainOfficeRoomCH5SR2 0
)

(local
	[local0 4] = [62 17 160 213]
	[local4 4] = [417 40 560 330]
	[local8 4] = [44 230 90 330]
)

(instance mainOfficeRoomCH5SR2 of P2Room
	(properties
		picture 180
		north 3365
		south 3335
		west 3345
	)

	(method (init)
		(super init: &rest)
		(jossOrTomFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(or
			(firstWaterCoolerFeature
				init: [local8 0] [local8 1] [local8 2] [local8 3]
			)
			(secondWaterCoolerFeature
				init: [local8 0] [local8 1] [local8 2] [local8 3]
			)
		)
		(paulsDoorFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
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

(instance jossOrTomFeature of P2Feature
	(properties
		nextRoom 3355
		exitDir 1
	)
)

(instance firstWaterCoolerFeature of P2Feature
	(properties
		scene 4890
		sceneScored 1
		doneFlag 752
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
		scene 4900
		doneFlag 753
	)
)

(instance paulsDoorFeature of ExitFeature
	(properties
		nextRoom 4635
		exitScene 3884
	)
)

