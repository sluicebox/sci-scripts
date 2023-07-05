;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3135)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)
(use System)

(public
	networkRoomCH5SR3 0
)

(local
	[local0 4] = [490 0 550 300]
)

(instance networkRoomCH5SR3 of P2Room
	(properties
		picture 151
		south 3115
		east 3115
		west 3115
	)

	(method (init)
		(if (not (SetFlag 756))
			(gSceneList add: global209)
			(gSceneList add: 6300)
			(= global209 0)
		)
		(curtis init:)
		(trevor init: whoDoit: trevCode)
		(gP2SongPlyr fadeOut: 0)
		(super init: &rest)
		(boxesFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(deskFeature init:)
		(gGame handsOn: 1)
	)
)

(instance boxesFeature of P2Feature
	(properties
		nextRoom 3145
		exitDir 1
	)
)

(instance deskFeature of P2Feature
	(properties
		nextRoom 3125
	)

	(method (init)
		(super init: (proc63002_10 0 190 100 200 108 306 0 306))
	)
)

(instance curtis of P2Fidget
	(properties
		x 267
		y 317
		view 11510
		initStart 0
		initFinish 1
		cycleStart 8
		cycleFinish 12
	)
)

(instance trevor of P2View
	(properties
		x 111
		y 337
		view 11510
		loop 1
	)
)

(instance trevCode of Code
	(properties)

	(method (doit)
		(if (not (SetFlag 757))
			(proc63002_7 6310)
		else
			(= global209 6320)
			(gEgo get: 26) ; trevCardKeyI
			(gCurRoom newRoom: 3015) ; mainHallRoomCH5SR1
		)
	)
)

