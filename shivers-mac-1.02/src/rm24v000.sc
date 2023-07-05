;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24000)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v000 0
)

(instance rm24v000 of ShiversRoom
	(properties
		picture 24000
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(proc951_7 22403)
		(proc951_9 22403)
		(gSounds play: 22403 -1 98 0)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24010
	)

	(method (init)
		(self createPoly: 124 52 110 52 110 114 152 114 152 52 124 52)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24130
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24130
	)
)

