;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31420)
(include sci.sh)
(use Main)

(public
	rm31v420 0
)

(instance rm31v420 of ShiversRoom
	(properties
		picture 31420
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31130
	)

	(method (init)
		(self createPoly: 70 116 202 116 202 1 66 1 66 116 84 116)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 31411
	)

	(method (init)
		(self createPoly: 207 1 204 117 240 117 240 1 207 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31120
	)
)

