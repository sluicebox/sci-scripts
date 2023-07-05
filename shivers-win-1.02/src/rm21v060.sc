;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21060)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm21v060 0
)

(instance rm21v060 of ShiversRoom
	(properties
		picture 21060
	)

	(method (init)
		(if (IsFlag 83)
			(= picture 21061)
		)
		(efExitForward init: 3)
		(efExitForwardLeftPlaque init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (and (!= [global118 25] 0) (IsFlag 83))
			(vPotView init:)
			(vMask init:)
		)
		(super init: &rest)
	)
)

(instance vMask of View
	(properties
		priority 30
		fixPriority 1
		view 21061
	)
)

(instance vPotView of View
	(properties
		x 178
		y 131
		view 0
	)

	(method (init)
		(self view: [global118 25] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 25)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21050
	)

	(method (init)
		(self createPoly: 0 1 0 88 33 88 33 1 0 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21070
	)

	(method (init)
		(self
			createPoly: 173 115 159 125 108 119 107 136 158 150 176 134 176 113
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeftPlaque of ExitFeature
	(properties
		nextRoom 21075
	)

	(method (init)
		(self
			createPoly:
				3
				104
				3
				90
				28
				90
				28
				131
				43
				137
				44
				142
				0
				142
				9
				135
				9
				117
				4
				104
		)
		(super init: &rest)
	)
)

