;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20840)
(include sci.sh)
(use Main)

(public
	rm20v840 0
)

(instance rm20v840 of ShiversRoom
	(properties
		picture 20840
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 20460
	)

	(method (init)
		(self createPoly: 60 30 203 30 203 113 60 113)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20410
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20400
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 144 0 144 0 0)
		(super init: &rest)
	)
)

