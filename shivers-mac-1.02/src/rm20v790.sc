;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20790)
(include sci.sh)
(use Main)

(public
	rm20v790 0
)

(instance rm20v790 of ShiversRoom
	(properties
		picture 20790
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
		nextRoom 20400
	)

	(method (init)
		(self createPoly: 71 142 71 132 106 3 207 5 215 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20810
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20510
	)
)

