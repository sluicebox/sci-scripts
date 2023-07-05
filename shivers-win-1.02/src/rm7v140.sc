;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7140)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v140 0
)

(instance rm7v140 of ShiversRoom
	(properties
		picture 7140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 8)
			(vOpenCupboard init:)
			(if (!= [global118 3] 0)
				(vPotView init:)
			)
		)
		(super init: &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7140
	)
)

(instance vPotView of View
	(properties
		x 159
		y 140
		view 0
	)

	(method (init)
		(self view: [global118 3] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 34 scaleY: 34 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7110
	)

	(method (init)
		(self createPoly: 103 56 104 96 61 143 239 141 173 97 173 57)
		(super init: &rest)
	)
)

