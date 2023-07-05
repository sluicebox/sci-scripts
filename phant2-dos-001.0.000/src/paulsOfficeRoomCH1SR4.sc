;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4641)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)

(public
	paulsOfficeRoomCH1SR4 0
)

(instance paulsOfficeRoomCH1SR4 of P2Room
	(properties
		picture 340
		east 4631
		west 4621
	)

	(method (init)
		(super init: &rest)
		(paulsPictureFea init:)
		(paulsDrawerFea init: (proc63002_10 183 283 495 280 493 300 185 302))
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
		sceneScored 1
		doneFlag 99
		nextRoom 3321
		exitScene 6710
	)

	(method (handleEvent event)
		(if (super handleEvent: event &rest)
			(= global212 0)
			(ClearFlag 5)
			(return 1)
		)
	)
)

