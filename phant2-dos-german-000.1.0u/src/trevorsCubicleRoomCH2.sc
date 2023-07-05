;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4102)
(include sci.sh)
(use Main)
(use nExit)

(public
	trevorsCubicleRoomCH2 0
)

(instance trevorsCubicleRoomCH2 of P2Room
	(properties
		picture 241
		south 3332
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(super init: &rest)
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

