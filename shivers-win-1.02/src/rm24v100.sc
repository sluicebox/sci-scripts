;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24100)
(include sci.sh)
(use Main)

(public
	rm24v100 0
)

(instance rm24v100 of ShiversRoom
	(properties
		picture 24100
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
		nextRoom 24090
	)

	(method (init)
		(self createPoly: 52 23 52 137 203 137 203 22 52 22)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24170
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24080
	)
)

