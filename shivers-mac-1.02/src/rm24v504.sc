;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24504)
(include sci.sh)
(use Main)

(public
	rm24v504 0
)

(instance rm24v504 of ShiversRoom
	(properties
		picture 24504
	)

	(method (init)
		(efExitLeft init: 0)
		(efExitRight init: 0)
		(gSounds play: 12405 0 82 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24503
	)

	(method (init)
		(self createPoly: 6 5 131 5 131 137 6 137 6 5)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24501
	)

	(method (init)
		(self createPoly: 134 5 134 137 258 137 258 5 135 5)
		(super init: &rest)
	)
)

