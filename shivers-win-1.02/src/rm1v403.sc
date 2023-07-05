;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1403)
(include sci.sh)
(use Main)

(public
	rm1v403 0
)

(instance rm1v403 of ShiversRoom
	(properties
		picture 1403
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
		nextRoom 1402
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1401
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1410
	)

	(method (init)
		(self createPoly: 46 140 79 76 204 76 243 141)
		(super init: &rest)
	)
)

