;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7110)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v110 0
)

(instance rm7v110 of ShiversRoom
	(properties
		picture 7110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 8)
			(vOpenCupboard init:)
			(efExitCupboards init: 3)
		)
		(super init: &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7111
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7220
	)

	(method (init)
		(self createPoly: 0 0 0 140 88 140 88 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7111
	)

	(method (init)
		(self createPoly: 90 52 90 114 206 114 206 52)
		(super init: &rest)
	)
)

(instance efExitCupboards of ExitFeature
	(properties
		nextRoom 7112
	)

	(method (init)
		(self createPoly: 91 117 91 141 234 141 234 117 91 117)
		(super init: &rest)
	)
)

