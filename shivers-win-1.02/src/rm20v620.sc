;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20620)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm20v620 0
)

(instance rm20v620 of ShiversRoom
	(properties
		picture 20620
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			(= picture 20621)
		else
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((View new:)
					view: 20620
					loop: temp0
					y: 143
					cel: [global540 (+ temp0 3)]
					setPri: 1 1
					init:
				)
			)
		)
		(efExitBox init: 3)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20610
	)

	(method (init)
		(self createPoly: 25 4 28 141 62 136 57 4 25 4)
		(super init: &rest)
	)
)

(instance efExitBox of ExitFeature
	(properties
		nextRoom 20550
	)

	(method (init)
		(self createPoly: 79 67 79 120 91 136 238 122 238 66 210 63 78 66)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20641
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20630
	)
)

