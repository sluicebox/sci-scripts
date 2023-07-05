;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32310)
(include sci.sh)
(use Main)

(public
	rm32v310 0
)

(instance rm32v310 of ShiversRoom
	(properties
		picture 32310
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32210
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

