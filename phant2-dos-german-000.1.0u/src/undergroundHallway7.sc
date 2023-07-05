;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3460)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)
(use ExitFeature)
(use P2Fidget)

(public
	undergroundHallway7 0
)

(local
	[local0 8] = [272 88 400 200 228 250 250 266]
)

(instance undergroundHallway7 of P2Room
	(properties
		picture 732
		south 3461
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 735)
			(doorOtherF init: [local0 0] [local0 1] [local0 2] [local0 3])
		else
			(doorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		)
		(toyTruckF init:)
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance doorF of ExitFeature
	(properties
		doneFlag 735
		nextRoom 3474
		exitScene 6370
	)
)

(instance doorOtherF of ExitFeature
	(properties
		nextRoom 3474
		exitScene 6341
	)
)

(instance toyTruckF of P2View
	(properties
		x 250
		y 241
		view 732
		scene 5356
		doneFlag 734
	)
)

(instance curtis of P2Fidget
	(properties
		x 349
		y 337
		view 17320
		initStart 1
		initFinish 2
		cycleStart 2
		cycleFinish 5
	)
)

