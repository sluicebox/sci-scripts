;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3001)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	doorCloseupRoom 0
)

(local
	[local0 4] = [380 0 645 335]
	[local4 4] = [110 60 240 170]
)

(instance doorCloseupRoom of CloseupRoom
	(properties
		picture 111
		exitRoom 3011
	)

	(method (init)
		(super init: &rest)
		(officeDoorFea init: [local0 0] [local0 1] [local0 2] [local0 3])
		(sensorFea init: [local4 0] [local4 1] [local4 2] [local4 3])
		(sensorFea addVerb: 6 delVerb: 4)
		(gGame handsOn: 1)
	)
)

(instance officeDoorFea of ExitFeature
	(properties
		doneFlag 12
		nextRoom 3011
		exitScene 3330
	)
)

(instance sensorFea of ExitFeature
	(properties
		doneFlag 11
		nextRoom 3311
		exitScene 3340
	)
)

