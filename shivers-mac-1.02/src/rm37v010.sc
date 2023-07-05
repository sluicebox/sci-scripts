;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37010)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v010 0
)

(instance rm37v010 of ShiversRoom
	(properties
		picture 37010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 43)
			(gSounds play: 10614 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37090
	)

	(method (init)
		(self createPoly: 55 125 86 102 92 50 128 47 170 51 175 101 207 125)
		(super init: &rest)
	)
)

