;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1361)
(include sci.sh)
(use Main)

(public
	rm1v361 0
)

(instance rm1v361 of ShiversRoom
	(properties
		picture 1361
	)

	(method (init)
		(efExitForwardVase init: 3)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1341
	)

	(method (init)
		(self
			createPoly: 28 142 53 116 94 59 92 29 222 29 213 59 221 116 236 142 28 142
		)
		(super init: &rest)
	)
)

(instance efExitForwardVase of ExitFeature
	(properties
		nextRoom 1340
	)

	(method (init)
		(self createPoly: 20 0 74 0 78 29 58 29 67 71 52 91 20 91 20 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1350
	)
)

