;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v220 0
)

(instance rm37v220 of ShiversRoom
	(properties
		picture 37220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitWindow init: 3)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 13707 0 82 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37180
	)

	(method (init)
		(self createPoly: 63 119 43 126 20 126 20 60 55 60)
		(super init: &rest)
	)
)

(instance efExitWindow of ExitFeature
	(properties
		nextRoom 37420
	)

	(method (init)
		(self createPoly: 171 123 115 113 119 35 166 25)
		(super init: &rest)
	)
)

