;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20390)
(include sci.sh)
(use Main)

(public
	rm20v390 0
)

(instance rm20v390 of ShiversRoom
	(properties
		picture 20390
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
		nextRoom 20100
	)

	(method (init)
		(self createPoly: 97 104 97 52 126 35 156 52 156 103)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20370
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20850
	)
)

