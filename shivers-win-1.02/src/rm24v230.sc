;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24230)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v230 0
)

(instance rm24v230 of ShiversRoom
	(properties
		picture 24231
	)

	(method (init)
		(efExitCrate init: 3)
		(efExitHorse init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (proc951_11 5 24000)
			(proc951_9 22404)
			(gSounds play: 22404 -1 0 0)
			(gSounds fade: 22404 50 6 30 0 0)
			(gSounds fade: 22402 0 6 30 1 0)
		)
		(super init: &rest)
	)
)

(instance efExitCrate of ExitFeature
	(properties
		nextRoom 24190
	)

	(method (init)
		(self createPoly: 47 54 105 54 105 99 45 105 45 54 48 54)
		(super init: &rest)
	)
)

(instance efExitHorse of ExitFeature
	(properties
		nextRoom 24220
	)

	(method (init)
		(self createPoly: 237 22 120 49 156 113 249 83 241 20 236 22)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24240
	)
)

