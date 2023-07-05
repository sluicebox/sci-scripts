;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8560)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v560 0
)

(instance rm8v560 of ShiversRoom
	(properties)

	(method (init)
		(efExitPodium init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 34)
			(= picture 8570)
		else
			(= picture 8560)
		)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8610
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8580
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8500
	)

	(method (init)
		(self createPoly: 30 143 55 105 55 29 154 29 154 125 161 142)
		(super init: &rest)
	)
)

(instance efExitPodium of ExitFeature
	(properties
		nextRoom 8530
	)

	(method (init)
		(self createPoly: 204 143 207 110 171 81 172 79 231 42 242 43 242 143)
		(super init: &rest)
	)
)

