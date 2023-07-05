;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4502)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)

(public
	tomsCubicleRoomCH2 0
)

(local
	[local0 4] = [376 185 406 225]
	[local4 4] = [403 130 442 168]
)

(instance tomsCubicleRoomCH2 of P2Room
	(properties
		picture 281
		south 3352
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(super init: &rest)
		(if (not (IsFlag 227))
			(tomsPhoneFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
			(tomsPhoneList init: [local4 0] [local4 1] [local4 2] [local4 3])
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 100)
		else
			(gP2SongPlyr fadeTo: 100)
		)
		(super dispose: &rest)
	)
)

(instance tomsPhoneFeature of P2Feature
	(properties
		nextRoom 4512
	)

	(method (init)
		(if (not (IsFlag 227))
			(super init: &rest)
			(if (not (== gPrevRoomNum 4512)) ; tomsCubicleRoomCH2SR1
				(= scene 4460)
			)
		else
			(return 0)
		)
	)
)

(instance tomsPhoneList of P2Feature
	(properties
		nextRoom 4522
	)
)

