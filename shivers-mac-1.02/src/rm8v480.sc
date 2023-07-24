;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8480)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm8v480 0
)

(instance rm8v480 of ShiversRoom
	(properties
		picture 8480
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitDown init: 3)
		(if (IsFlag 40)
			(= picture 8481)
			(if (> [global118 7] 0)
				(vPotView init:)
			)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8430
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 8490
	)

	(method (init)
		(self
			createPoly: 97 135 102 90 114 86 142 86 157 90 163 129 163 136 153 144 103 143
		)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 129
		y 125
		view 0
	)

	(method (init)
		(self view: [global118 7] loop: 2)
		(super init: &rest)
		(self setScale: scaleX: 34 scaleY: 34 setPri: 10 1)
	)
)

