;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7160)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v160 0
)

(instance rm7v160 of ShiversRoom
	(properties
		picture 7160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(if (IsFlag 8)
			(vOpenCupboard init:)
		)
		(super init: &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7162
	)

	(method (init)
		(self createPoly: 123 122 77 135 95 143 120 143 154 132 123 123)
		(super init: &rest)
	)
)

