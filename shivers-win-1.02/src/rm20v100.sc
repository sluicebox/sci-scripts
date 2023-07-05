;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20100)
(include sci.sh)
(use Main)

(public
	rm20v100 0
)

(instance rm20v100 of ShiversRoom
	(properties
		picture 20100
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
		nextRoom 20040
	)

	(method (init)
		(self createPoly: 88 23 171 23 171 117 90 117 90 23)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20070
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20090
	)
)

