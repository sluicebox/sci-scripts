;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14170)
(include sci.sh)
(use Main)
(use SkeletonDialPuzzle)

(public
	rm14v17 0
)

(instance rm14v17 of ShiversRoom
	(properties
		picture 14170
	)

	(method (init)
		(efExitBack init: 8)
		(SkeletonDialPuzzle init: 0 143 10 1)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 14110
	)

	(method (init)
		(if (== gPrevRoomNum 14290) ; rm14v290
			(= nextRoom 14290)
		)
		(self
			createPoly:
				0
				0
				20
				20
				20
				123
				243
				123
				243
				20
				20
				20
				0
				0
				263
				0
				263
				143
				0
				143
		)
		(super init: &rest)
	)
)

