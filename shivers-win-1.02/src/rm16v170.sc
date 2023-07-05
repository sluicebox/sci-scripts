;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v170 0
)

(instance rm16v170 of ShiversRoom
	(properties
		picture 16170
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16174)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitStairs init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16180
	)
)

(instance efExitStairs of ExitFeature
	(properties
		nextRoom 16620
	)

	(method (init)
		(self
			createPoly:
				136
				142
				136
				62
				140
				44
				112
				44
				112
				56
				54
				50
				54
				1
				151
				1
				214
				132
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16190
	)

	(method (init)
		(self createPoly: 123 142 122 64 112 56 53 50 20 49 20 114 62 143)
		(super init: &rest)
	)
)

