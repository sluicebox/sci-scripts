;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32170)
(include sci.sh)
(use Main)

(public
	rm32v170 0
)

(instance rm32v170 of ShiversRoom
	(properties
		picture 32170
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32190
	)

	(method (init)
		(self
			createPoly:
				62
				137
				77
				116
				77
				24
				194
				24
				189
				110
				203
				132
				203
				137
				62
				137
		)
		(super init: &rest)
	)
)

