;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20470)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm20v470 0
)

(instance rm20v470 of ShiversRoom
	(properties
		picture 20470
	)

	(method (init &tmp temp0)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 17)
			(= picture 20471)
		else
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((View new:)
					view: 20470
					loop: temp0
					cel: [global540 temp0]
					setPri: 10 1
					init:
				)
			)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20510
	)

	(method (init)
		(self createPoly: 132 2 130 142 171 142 170 0 132 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20450
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20820
	)
)

