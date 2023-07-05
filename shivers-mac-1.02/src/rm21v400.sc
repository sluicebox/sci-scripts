;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21400)
(include sci.sh)
(use Main)
(use SkeletonDialPuzzle)

(public
	rm21v400 0
)

(instance rm21v400 of ShiversRoom
	(properties
		picture 21400
	)

	(method (init)
		(efExitBack init: 8)
		(SkeletonDialPuzzle init: 100 27 10 3)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21160
	)

	(method (init)
		(self
			createPoly:
				121
				22
				146
				22
				198
				64
				198
				82
				145
				125
				129
				125
				71
				82
				71
				65
				117
				23
				117
				2
				9
				2
				9
				140
				262
				140
				262
				2
				119
				2
				120
				22
		)
		(super init: &rest)
	)
)

