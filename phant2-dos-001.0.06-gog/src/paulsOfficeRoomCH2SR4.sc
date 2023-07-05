;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4642)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)

(public
	paulsOfficeRoomCH2SR4 0
)

(instance paulsOfficeRoomCH2SR4 of P2Room
	(properties
		picture 340
		east 4632
		west 4622
	)

	(method (init)
		(super init: &rest)
		(paulsPictureFea init:)
		(paulsDrawerFea init:)
		(paulsComputer init:)
		(gGame handsOn: 1)
	)
)

(instance paulsPictureFea of P2Feature
	(properties
		scene 6830
		sceneScored 1
		doneFlag 252
	)

	(method (init)
		(if (super init:)
			(self addTarget: (proc63002_10 226 38 320 32 326 103 234 111) 0)
		)
	)
)

(instance paulsDrawerFea of ExitFeature
	(properties
		readyFlag 253
		nextRoom 4650
		exitScene 6772
	)

	(method (init)
		(if (and (IsFlag 95) (super init:))
			(self addTarget: (proc63002_10 183 283 495 280 493 300 185 302) 0)
		)
	)
)

(instance paulsComputer of P2View
	(properties
		x 434
		y 102
		view 340
		nextRoom 4672
	)
)

