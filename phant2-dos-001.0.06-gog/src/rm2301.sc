;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42301)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	rm2301 0
)

(instance rm2301 of P2Room
	(properties
		picture 2301
		south 42302
		east 42302
		west 42302
	)

	(method (init)
		(super init: &rest)
		(doorF init: 198 95 303 209)
		(gGame handsOn: 1)
	)
)

(instance doorF of ExitFeature
	(properties
		nextRoom 42060
		exitDir 1
		exitScene 10605
	)
)

