;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3009)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)

(public
	london_Door_1 0
)

(instance london_Door_1 of CloseupLocation
	(properties
		noun 12
		heading 0
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(if (IsFlag 98)
			(super init: 3004)
			(cu_door_exit init:)
		else
			(super init: 3003)
		)
		(= plane global116)
	)
)

(instance cu_door_exit of ExitFeature
	(properties
		nsLeft 200
		nsTop 80
		nsRight 386
		nsBottom 237
		nextRoom 3002
	)
)

