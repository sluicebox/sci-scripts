;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4303)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	bobsCubicleRoomCH3 0
)

(instance bobsCubicleRoomCH3 of P2Room
	(properties
		picture 262
		south 3343
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 80)
		(= global241 60)
		(if (not (IsFlag 400))
			(= picture 264)
		)
		(super init: &rest)
		(bobsDeskFeat init: (proc63002_10 195 125 264 128 263 207 196 206))
		(gGame handsOn: 1)
	)
)

(instance bobsDeskFeat of ExitFeature
	(properties
		sceneScored 1
		doneFlag 400
		nextRoom 3313
		exitScene 4640
	)
)

