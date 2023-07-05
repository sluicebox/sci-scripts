;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33100)
(include sci.sh)
(use Main)

(public
	rm33v100 0
)

(instance rm33v100 of ShiversRoom
	(properties
		picture 33100
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33110
	)

	(method (init)
		(self createPoly: 246 0 246 143 157 143 157 0 245 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33170
	)

	(method (init)
		(self createPoly: 0 0 55 0 55 142 0 142 0 1)
		(super init: &rest)
	)
)

