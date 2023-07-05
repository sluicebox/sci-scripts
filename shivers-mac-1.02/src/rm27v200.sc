;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v200 0
)

(instance rm27v200 of ShiversRoom
	(properties
		picture 27200
	)

	(method (init)
		(if (IsFlag 6)
			(ClearFlag 6)
			(gSounds play: 10405 0 50 0)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(efExitBox init: 1)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27213
	)

	(method (init)
		(self createPoly: 51 142 97 38 147 38 158 142 51 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27201
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27201
	)
)

(instance efExitBox of ExitFeature
	(properties
		nextRoom 27211
	)

	(method (init)
		(self createPoly: 205 61 242 56 242 101 205 93 205 61)
		(super init: &rest)
	)
)

