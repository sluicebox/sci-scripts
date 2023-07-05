;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27221)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v221 0
)

(instance rm27v221 of ShiversRoom
	(properties
		picture 27221
	)

	(method (init)
		(if (IsFlag 6)
			(ClearFlag 6)
			(gSounds play: 10405 0 50 0)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27232
	)

	(method (init)
		(self createPoly: 88 142 118 52 146 52 184 142 88 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27220
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27220
	)
)

