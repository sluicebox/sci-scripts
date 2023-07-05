;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20110)
(include sci.sh)
(use Main)

(public
	rm20v110 0
)

(instance rm20v110 of ShiversRoom
	(properties
		picture 20110
	)

	(method (init)
		(efExitStairs init: 3)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitDoorLeft init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20070
	)

	(method (init)
		(self createPoly: 49 144 80 94 80 60 170 60 170 94 215 144 49 144)
		(super init: &rest)
	)
)

(instance efExitStairs of ExitFeature
	(properties
		nextRoom 20370
	)

	(method (init)
		(self createPoly: 175 25 173 93 232 93 232 25 175 25)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20120
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20140
	)

	(method (init)
		(self createPoly: 0 0 0 36 12 40 12 114 0 121 0 144 35 144 35 0 0 0)
		(super init: &rest)
	)
)

(instance efExitDoorLeft of ExitFeature
	(properties
		nextRoom 20040
	)

	(method (init)
		(self createPoly: 0 36 12 40 12 114 0 121 0 36)
		(super init: &rest)
	)
)

