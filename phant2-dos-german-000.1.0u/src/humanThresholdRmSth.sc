;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9500)
(include sci.sh)
(use nExit)
(use ExitFeature)

(public
	humanThresholdRmSth 0
)

(instance humanThresholdRmSth of P2Room
	(properties
		picture 950
		south 9001
	)

	(method (init)
		(door init: 263 33 377 192)
		(super init: &rest)
	)
)

(instance door of ExitFeature
	(properties
		nextRoom 9001
		exitDir 0
		exitScene 6582
	)
)

