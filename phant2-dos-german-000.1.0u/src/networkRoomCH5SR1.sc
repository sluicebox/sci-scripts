;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3115)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)

(public
	networkRoomCH5SR1 0
)

(local
	[local0 2] = [447 230]
)

(instance networkRoomCH5SR1 of P2Room
	(properties
		picture 130
		south 3135
		east 3135
		west 3135
	)

	(method (init)
		(monitorV init: [local0 0] [local0 1] delVerb: 4 isHot: 0)
		(super init: &rest)
		(deskFeature
			init:
				(proc63002_10
					491
					195
					616
					226
					606
					333
					453
					333
					443
					326
					443
					295
					414
					295
					401
					279
					402
					200
				)
		)
		(exitFeature
			init: (proc63002_10 188 73 203 61 263 72 263 248 207 266 192 247)
		)
		(gGame handsOn: 1)
	)
)

(instance deskFeature of P2Feature
	(properties
		nextRoom 3125
	)
)

(instance exitFeature of ExitFeature
	(properties
		nextRoom 3015
		exitScene 6180
	)
)

(instance monitorV of P2View
	(properties
		view 130
	)
)

