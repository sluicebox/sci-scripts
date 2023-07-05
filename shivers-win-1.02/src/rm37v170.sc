;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37170)
(include sci.sh)
(use Main)

(public
	rm37v170 0
)

(instance rm37v170 of ShiversRoom
	(properties
		picture 37170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37180
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 37280
	)

	(method (init)
		(self createPoly: 170 137 165 94 174 93 176 70 142 40 90 41 86 137)
		(super init: &rest)
	)
)

