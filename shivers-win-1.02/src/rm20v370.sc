;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20370)
(include sci.sh)
(use Main)

(public
	rm20v370 0
)

(instance rm20v370 of ShiversRoom
	(properties
		picture 20370
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20350
	)

	(method (init)
		(self createPoly: 82 121 82 92 92 45 120 0 139 0 169 43 183 91 182 122)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20380
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20390
	)
)

