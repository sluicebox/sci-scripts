;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6444)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	blBackCH4SR4 0
)

(instance blBackCH4SR4 of P2Room
	(properties
		picture 841
		south 6454
		east 6454
		west 6454
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(exitFeat init:)
		(gGame handsOn: 1)
	)
)

(instance exitFeat of ExitFeature
	(properties
		nextRoom 6424
		exitDir 0
		exitScene 8199
	)

	(method (init)
		(super init: 272 30 374 220)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(SetFlag 1001)
		)
		(event claimed:)
	)
)

