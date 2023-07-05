;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v200 0
)

(instance rm32v200 of ShiversRoom
	(properties
		picture 32200
	)

	(method (init)
		(if (IsFlag 81)
			(= picture 32201)
		else
			(= picture 32200)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32210
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32240
	)

	(method (init)
		(self createPoly: 55 142 58 13 137 24 134 142 55 142)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 32810
	)

	(method (init)
		(self createPoly: 137 119 157 119 160 130 160 143 136 143 136 119)
		(super init: &rest)
	)
)

