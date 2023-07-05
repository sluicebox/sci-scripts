;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37150)
(include sci.sh)
(use Main)

(public
	rm37v150 0
)

(instance rm37v150 of ShiversRoom
	(properties
		picture 37150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37160
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 20
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 37151
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37230
	)

	(method (init)
		(self createPoly: 93 124 93 40 131 25 169 37 169 124)
		(super init: &rest)
	)
)

