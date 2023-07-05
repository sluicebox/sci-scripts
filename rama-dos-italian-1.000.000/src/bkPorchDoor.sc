;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4002)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Feature)

(public
	bkPorchDoor 0
)

(instance bkPorchDoor of CloseupLocation
	(properties
		heading 0
	)

	(method (init)
		(cond
			((IsFlag 39)
				(super init: 4005)
				(= picture 4005)
				(exitToCountRm init:)
				(gCurRoom exitN: exitToCountRm)
			)
			((IsFlag 34)
				(super init: 4016)
				(= picture 4016)
				(exitToCountRm init:)
				(gCurRoom exitN: exitToCountRm)
			)
			(else
				(super init: 4015)
				(= picture 4015)
			)
		)
		(= plane global116)
		(= global269 1)
		(door_0 init:)
	)
)

(instance exitToCountRm of ExitFeature
	(properties
		nsBottom 221
		nsLeft 171
		nsRight 400
		nsTop 72
		nextRoom 4004
		exitStyle 256
	)
)

(instance door_0 of Feature
	(properties
		noun 2
		x 294
		y 136
		nsBottom 273
		nsLeft -1
		nsRight 590
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

