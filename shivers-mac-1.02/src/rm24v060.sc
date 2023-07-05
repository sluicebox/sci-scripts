;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24060)
(include sci.sh)
(use Main)

(public
	rm24v060 0
)

(instance rm24v060 of ShiversRoom
	(properties
		picture 24060
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
		nextRoom 24070
	)

	(method (init)
		(self createPoly: 84 28 84 140 199 140 199 27 84 27)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24010
	)
)

