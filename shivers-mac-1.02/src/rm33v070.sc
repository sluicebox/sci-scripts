;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33070)
(include sci.sh)
(use Main)

(public
	rm33v070 0
)

(instance rm33v070 of ShiversRoom
	(properties
		picture 33070
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
		nextRoom 33080
	)

	(method (init)
		(self createPoly: 83 141 83 18 95 29 176 29 175 128 189 142 83 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33220
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33130
	)
)

