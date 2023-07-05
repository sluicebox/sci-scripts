;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v170 0
)

(instance rm33v170 of ShiversRoom
	(properties
		picture 33170
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 6)
			(ClearFlag 6)
			(gSounds play: 10405 0 50 0)
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33100
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33180
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 31 10 31 10 127 20 127 20 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33210
	)

	(method (init)
		(self
			createPoly: 10 31 20 31 20 0 41 0 41 144 20 144 20 127 10 127 10 31
		)
		(super init: &rest)
	)
)

