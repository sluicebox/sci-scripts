;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33050)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v050 0
)

(instance rm33v050 of ShiversRoom
	(properties
		picture 33050
	)

	(method (init)
		(if (IsFlag 75)
			(self picture: 33051)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitRightDoor init: 3)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33060
	)

	(method (init)
		(self createPoly: 86 142 106 112 106 40 166 40 166 118 180 142 86 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33250
	)
)

(instance efExitRightDoor of ExitFeature
	(properties
		nextRoom 33310
	)

	(method (init)
		(self createPoly: 179 18 173 130 180 142 229 142 216 0 196 0 180 17)
		(super init: &rest)
	)
)

