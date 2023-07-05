;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26260)
(include sci.sh)
(use Main)

(public
	rm26v260 0
)

(instance rm26v260 of ShiversRoom
	(properties
		picture 26260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26300
	)

	(method (init)
		(self createPoly: 56 142 60 137 61 9 191 9 202 12 202 0 231 0 231 144)
		(super init: &rest)
	)
)

