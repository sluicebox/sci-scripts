;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8120)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm8v120 0
)

(instance rm8v120 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(if (IsFlag 34)
			(= picture 8120)
		else
			(= picture 8130)
		)
		(if (IsFlag 40)
			(vStatue init:)
		)
		(super init: &rest)
	)
)

(instance vStatue of View
	(properties
		priority 20
		fixPriority 1
		view 8121
	)

	(method (init)
		(if (IsFlag 34)
			(= view 8121)
		else
			(= view 8131)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8140
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 8280
	)

	(method (init)
		(self createPoly: 75 143 72 68 72 1 21 1 21 143)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 8020
	)

	(method (init)
		(self createPoly: 208 142 212 70 212 1 243 1 243 142)
		(super init: &rest)
	)
)

