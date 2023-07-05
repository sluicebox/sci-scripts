;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4003)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)

(public
	bkPuzPorchDoor 0
)

(instance bkPuzPorchDoor of CloseupLocation
	(properties
		heading 0
	)

	(method (init)
		(super init: 4001)
		(= plane global116)
		(exitToPuzzle init:)
		(self exitN: exitToPuzzle)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance exitToPuzzle of ExitFeature
	(properties
		nsBottom 226
		nsLeft 224
		nsRight 397
		nsTop 87
		nextRoom 4004
	)
)

