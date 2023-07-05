;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20190)
(include sci.sh)
(use Main)
(use SkeletonDialPuzzle)

(public
	rm20v190 0
)

(instance rm20v190 of ShiversRoom
	(properties
		picture 20190
	)

	(method (init)
		(efExitBack init: 8)
		(SkeletonDialPuzzle init: 0 0 10 4)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20120
	)

	(method (init)
		(self
			createPoly:
				0
				1
				261
				2
				261
				142
				0
				142
				0
				1
				20
				17
				234
				18
				233
				130
				20
				130
				20
				18
		)
		(super init: &rest)
	)
)

