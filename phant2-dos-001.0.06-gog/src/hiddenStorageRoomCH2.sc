;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3202)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)
(use P2Fidget)

(public
	hiddenStorageRoomCH2 0
)

(local
	[local0 4] = [50 150 150 270]
	[local4 4] = [334 274 430 334]
)

(instance hiddenStorageRoomCH2 of P2Room
	(properties
		picture 380
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary stop: 1)
		else
			(gP2SongPlyr fadeOut:)
		)
		(super init: &rest)
		(doorFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(drawerFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 152
		y 305
		view 13801
		initStart 0
		initFinish 5
		cycleStart 10
		cycleFinish 20
	)
)

(instance doorFeature of ExitFeature
	(properties
		nextRoom 3142
		exitDir 5
		exitScene 6965
	)
)

(instance drawerFeature of ExitFeature
	(properties
		nextRoom 3212
		exitScene 6940
	)

	(method (init)
		(if (not (gEgo has: 12)) ; lockerI
			(super init: &rest)
		)
	)
)

