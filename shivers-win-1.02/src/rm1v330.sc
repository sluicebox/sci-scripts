;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1330)
(include sci.sh)
(use Main)

(public
	rm1v330 0
)

(instance rm1v330 of ShiversRoom
	(properties
		picture 1330
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1343
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1342
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1340
	)

	(method (init)
		(self createPoly: 154 58 243 58 243 144 154 144 154 58)
		(super init: &rest)
	)
)

