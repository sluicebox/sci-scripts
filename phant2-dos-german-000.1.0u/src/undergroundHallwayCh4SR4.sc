;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3461)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)
(use P2Fidget)

(public
	undergroundHallwayCh4SR4 0
)

(local
	[local0 4] = [271 60 400 200]
)

(instance undergroundHallwayCh4SR4 of P2Room
	(properties
		picture 733
		south 3460
	)

	(method (init)
		(super init: &rest)
		(doorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance doorF of ExitFeature
	(properties
		nextRoom 3454
		exitScene 6342
	)
)

(instance curtis of P2Fidget
	(properties
		x 319
		y 338
		view 17330
	)
)

