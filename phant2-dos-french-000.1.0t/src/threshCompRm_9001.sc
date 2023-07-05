;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9001)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)
(use P2Fidget)

(public
	threshCompRm 0
)

(instance threshCompRm of P2Room
	(properties
		picture 811
	)

	(method (init)
		(super init: &rest)
		(thresholdDoorF init: 233 47 308 131)
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 379
		y 250
		view 18110
	)
)

(instance thresholdDoorF of ExitFeature
	(properties
		nextRoom 9400
		exitDir 7
		exitScene 6581
	)
)

