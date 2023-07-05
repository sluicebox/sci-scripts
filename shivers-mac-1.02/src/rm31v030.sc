;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31030)
(include sci.sh)
(use Main)

(public
	rm31v030 0
)

(instance rm31v030 of ShiversRoom
	(properties
		picture 31030
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31040
	)

	(method (init)
		(self createPoly: 200 0 264 0 262 144 200 144 200 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31050
	)
)

