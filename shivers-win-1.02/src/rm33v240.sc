;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33240)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v240 0
)

(instance rm33v240 of ShiversRoom
	(properties
		picture 33240
	)

	(method (init)
		(if (IsFlag 75)
			(self picture: 33241)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(efExitLeftDoor init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33250
	)

	(method (init)
		(self createPoly: 91 142 115 110 115 42 161 42 161 108 182 142 92 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33060
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33060
	)
)

(instance efExitLeftDoor of ExitFeature
	(properties
		nextRoom 33310
	)

	(method (init)
		(self createPoly: 26 0 26 143 86 143 89 139 80 9 71 0 27 0)
		(super init: &rest)
	)
)

