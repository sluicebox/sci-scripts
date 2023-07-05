;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20660)
(include sci.sh)
(use Main)

(public
	rm20v660 0
)

(instance rm20v660 of ShiversRoom
	(properties
		picture 20660
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20640
	)

	(method (init)
		(self createPoly: 146 3 146 123 171 142 230 140 230 3 147 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20670
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20680
	)
)

