;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23540)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm23v540 0
)

(instance rm23v540 of ShiversRoom
	(properties
		picture 23540
	)

	(method (init)
		(if (IsFlag 23)
			(vBull init:)
			(if (!= [global118 29] 0)
				(vPotView init:)
			)
		)
		(efExitForward init: 3)
		(efExitPlaque init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23530
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23550
	)

	(method (init)
		(self createPoly: 263 0 234 0 234 69 200 69 200 143 263 143 263 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23590
	)

	(method (init)
		(self
			createPoly:
				157
				134
				159
				127
				168
				119
				166
				109
				178
				83
				178
				19
				75
				27
				74
				107
				67
				118
				80
				131
				155
				131
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23900
	)

	(method (init)
		(self
			createPoly:
				0
				94
				29
				91
				39
				104
				23
				107
				27
				137
				40
				142
				13
				142
				16
				137
				0
				109
				0
				95
		)
		(super init: &rest)
	)
)

(instance vBull of View
	(properties
		view 23540
	)

	(method (init)
		(self setPri: 1 1)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 250
		y 109
		view 0
	)

	(method (init)
		(self view: [global118 29] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 34 scaleY: 34 setPri: 10 1)
	)
)

