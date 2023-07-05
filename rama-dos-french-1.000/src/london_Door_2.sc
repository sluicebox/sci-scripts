;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3010)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)

(public
	london_Door_2 0
)

(instance london_Door_2 of CloseupLocation
	(properties
		noun 5
		heading 0
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(if (IsFlag 99)
			(super init: 3114)
			(cu_door_exit init:)
		else
			(super init: 3113)
		)
		(= plane global116)
	)
)

(instance cu_door_exit of ExitFeature
	(properties
		nsBottom 237
		nsLeft 200
		nsRight 386
		nsTop 80
		nextRoom 3008
	)
)

