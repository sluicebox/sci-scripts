;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3322)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)

(public
	mainOfficeRoomCH2SR2 0
)

(local
	[local0 4] = [62 17 160 230]
	[local4 4] = [417 40 560 330]
)

(instance mainOfficeRoomCH2SR2 of P2Room
	(properties
		picture 180
		north 3362
		south 3332
		west 3342
	)

	(method (init)
		(if (and (IsFlag 228) (not (gRoboGary isPlaying:)))
			(gRoboGary
				setScore: 4 (if (IsFlag 227) 3022 else 3021) 2 8 12 3
				start:
			)
		)
		(curtis init:)
		(super init: &rest)
		(or
			(paulDistPaulsDoorFeature
				init: [local0 0] [local0 1] [local0 2] [local0 3]
			)
			(paulHerePaulsDoorFeature
				init: [local0 0] [local0 1] [local0 2] [local0 3]
			)
		)
		(jossOrTomFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 325
		y 323
		view 11800
		initStart 0
		initFinish 0
		cycleStart 7
	)
)

(instance paulDistPaulsDoorFeature of ExitFeature
	(properties
		readyFlag 227
		nextRoom 4632
	)

	(method (init)
		(if (not (IsFlag 251))
			(super init: &rest)
		)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(= global209 (if (SetFlag 111) 3884 else 4390))
		)
	)
)

(instance paulHerePaulsDoorFeature of P2Feature
	(properties
		scene 4173
	)
)

(instance jossOrTomFeature of P2Feature
	(properties
		nextRoom 3352
		exitDir 1
	)
)

