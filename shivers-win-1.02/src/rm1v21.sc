;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1021)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v21 0
)

(instance rm1v21 of ShiversRoom
	(properties
		picture 1021
	)

	(method (init)
		(gSounds fade: 10111 98 1 40 0 0)
		(if (IsFlag 33)
			(vLetter init:)
		)
		(efExitGate init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitMailBox init: 3)
		(super init: &rest)
		(if (IsFlag 43)
			(ClearFlag 43)
			(proc951_9 10128)
			(gSounds play: 10128 0 82 0)
		)
	)
)

(instance vLetter of View
	(properties
		priority 20
		fixPriority 1
		view 1021
	)
)

(instance efExitGate of ExitFeature
	(properties
		nextRoom 1012
	)

	(method (init)
		(self
			createPoly:
				128
				40
				128
				143
				238
				143
				229
				40
				216
				27
				181
				20
				145
				24
				128
				39
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1060
	)
)

(instance efExitMailBox of ExitFeature
	(properties
		nextRoom 1000
	)

	(method (init)
		(self createPoly: 22 51 22 143 82 142 82 51 24 51)
		(super init: &rest)
	)
)

