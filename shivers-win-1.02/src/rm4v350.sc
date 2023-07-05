;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4350)
(include sci.sh)
(use Main)

(public
	rm4v350 0
)

(instance rm4v350 of ShiversRoom
	(properties
		picture 4040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4340
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4360
	)

	(method (init)
		(self createPoly: 210 0 262 0 262 142 210 142 210 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 4320
	)

	(method (init)
		(self createPoly: 176 112 86 112 117 77 117 61 145 61 145 78)
		(super init: &rest)
	)
)

