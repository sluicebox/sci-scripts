;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v110 0
)

(instance rm24v110 of ShiversRoom
	(properties
		picture 24110
	)

	(method (init)
		(proc951_9 22403)
		(gSounds play: 22403 -1 98 0)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (or (proc951_11 1 24000) (proc951_11 5 24000))
			(gSounds fade: 22404 0 1 30 1 0)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24130
	)

	(method (init)
		(self createPoly: 104 52 104 134 153 134 153 52 105 52)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24090
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24060
	)
)

