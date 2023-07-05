;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24280)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v280 0
)

(instance rm24v280 of ShiversRoom
	(properties
		picture 24281
	)

	(method (init)
		(efExitUp init: 4)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(proc951_7 22402)
		(proc951_9 22402)
		(gSounds play: 22402 -1 98 0)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 24290
	)

	(method (init)
		(self createPoly: 76 0 76 23 242 23 242 0 76 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24230
	)

	(method (init)
		(self createPoly: 65 47 226 47 226 134 63 134 63 47 65 47)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24310
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24300
	)
)

