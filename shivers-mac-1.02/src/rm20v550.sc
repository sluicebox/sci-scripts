;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20550)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v550 0
)

(instance rm20v550 of ShiversRoom
	(properties
		picture 20550
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			(= picture 20551)
			(efExitDown init: 3)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20585
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20500
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 20552
	)

	(method (init)
		(self createPoly: 48 0 58 25 199 25 221 0)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 20553
	)

	(method (init)
		(self createPoly: 163 94 20 94 20 73)
		(super init: &rest)
	)
)

