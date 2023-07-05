;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4302)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)

(public
	bobsCubicleRoomCH2 0
)

(instance bobsCubicleRoomCH2 of P2Room
	(properties
		picture 263
		south 3342
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(super init: &rest)
		(bobsButtonF init:)
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

(instance bobsButtonF of P2Feature
	(properties
		nextRoom 4312
	)

	(method (init)
		(if (not (IsFlag 244))
			(super init: (proc63002_10 141 224 297 207 387 289 145 294))
		)
	)
)

