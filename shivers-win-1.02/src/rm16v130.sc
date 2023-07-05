;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16130)
(include sci.sh)
(use Main)

(public
	rm16v130 0
)

(instance rm16v130 of ShiversRoom
	(properties
		picture 16130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16710
	)
)

(instance efExitRight of ExitFeature ; UNUSED
	(properties
		nextRoom 16140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16500
	)

	(method (init)
		(self createPoly: 102 145 95 120 55 85 20 79 20 1 243 1 242 142)
		(super init: &rest)
	)
)

