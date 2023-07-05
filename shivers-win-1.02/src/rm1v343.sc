;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1343)
(include sci.sh)
(use Main)

(public
	rm1v343 0
)

(instance rm1v343 of ShiversRoom
	(properties
		picture 1343
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1342
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1350
	)

	(method (init)
		(self createPoly: 3 142 65 69 65 28 200 28 200 69 258 141)
		(super init: &rest)
	)
)

