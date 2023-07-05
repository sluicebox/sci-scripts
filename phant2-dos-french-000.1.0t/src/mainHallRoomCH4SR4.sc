;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3044)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)

(public
	mainHallRoomCH4SR4 0
)

(local
	[local0 4] = [276 20 366 200]
)

(instance mainHallRoomCH4SR4 of P2Room
	(properties
		picture 770
		north 3064
		south 3034
	)

	(method (init)
		(gP2SongPlyr fadeIn: (if (IsFlag 521) 3041 else 3042))
		(curtis init:)
		(super init: &rest)
		((ScriptID 63000 0) exitScene: 4472) ; nExit
		(glassDoorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance glassDoorF of ExitFeature
	(properties
		nextRoom 3064
		exitScene 4772
	)
)

(instance curtis of P2Fidget
	(properties
		x 343
		y 338
		view 17700
		initStart 0
		initFinish 2
		cycleStart 8
		cycleFinish 16
	)
)

