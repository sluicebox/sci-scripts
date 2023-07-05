;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4645)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)

(public
	paulsOfficeRoomCH5SR4 0
)

(instance paulsOfficeRoomCH5SR4 of P2Room
	(properties
		picture 340
		east 4635
		west 4625
	)

	(method (init)
		(super init: &rest)
		(paulsPictureFea init:)
		(paulsDrawerFea init: (proc63002_10 183 283 495 280 493 300 185 302))
		(paulsComputer
			init:
			addTarget: (proc63002_10 439 54 443 0 592 0 561 104)
		)
		(gGame handsOn: 1)
	)
)

(instance paulsPictureFea of P2Feature
	(properties
		scene 6750
		doneFlag 96
	)

	(method (init)
		(if (super init:)
			(self addTarget: (proc63002_10 226 38 320 32 326 103 234 111) 0)
		)
	)
)

(instance paulsDrawerFea of ExitFeature
	(properties
		nextRoom 4650
	)

	(method (handleEvent event)
		(if (super handleEvent: event &rest)
			(= global209 6776)
			(return 1)
		)
	)
)

(instance paulsComputer of P2View
	(properties
		x 448
		y 61
		view 342
		nextRoom 4655
	)

	(method (init)
		(super init: &rest)
	)
)

