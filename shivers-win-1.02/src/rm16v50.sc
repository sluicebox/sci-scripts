;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16050)
(include sci.sh)
(use Main)

(public
	rm16v50 0
)

(instance rm16v50 of ShiversRoom
	(properties
		picture 16050
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16020
	)

	(method (init)
		(self createPoly: 71 145 96 117 96 60 166 60 166 117 193 144)
		(super init: &rest)
	)
)

