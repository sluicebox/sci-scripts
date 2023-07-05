;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37130)
(include sci.sh)
(use Main)

(public
	rm37v130 0
)

(instance rm37v130 of ShiversRoom
	(properties
		picture 37130
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
		nextRoom 37160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37070
	)

	(method (init)
		(self createPoly: 74 132 108 48 148 48 186 86 207 134)
		(super init: &rest)
	)
)

