;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4503)
(include sci.sh)
(use Main)
(use nExit)

(public
	tomsCubicleRoomCH3 0
)

(instance tomsCubicleRoomCH3 of P2Room
	(properties
		picture 281
		south 3353
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 80)
		(= global241 60)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

