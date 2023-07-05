;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9210)
(include sci.sh)
(use Main)

(public
	rm9v21 0
)

(instance rm9v21 of ShiversRoom
	(properties
		picture 9210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9280
	)

	(method (init)
		(self createPoly: 57 142 29 95 23 12 68 12 72 96 149 144)
		(super init: &rest)
	)
)

