;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1003)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v03 0
)

(instance rm1v03 of ShiversRoom
	(properties
		picture 1003
	)

	(method (init)
		(gSounds play: 10618 0 82 0)
		(proc951_16 20)
		(efExitLetter init: 0)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 1000
	)

	(method (init)
		(self
			createPoly: 1 1 7 1 7 118 254 118 254 29 8 29 8 1 262 1 262 141 1 141
		)
		(if (IsFlag 33)
			(= nextRoom 1002)
		)
		(super init: &rest)
	)
)

(instance efExitLetter of ExitFeature
	(properties
		nextRoom 1004
	)

	(method (init)
		(self createPoly: 8 117 253 117 253 30 8 30)
		(super init: &rest)
	)
)

