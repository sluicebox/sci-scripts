;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20585)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm20v585 0
)

(instance rm20v585 of ShiversRoom
	(properties
		picture 20585
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			(= picture 20586)
		else
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((View new:)
					view: 20585
					loop: temp0
					cel: [global540 temp0]
					setPri: 1 1
					init:
				)
			)
		)
		(efExitForward init: 3)
		(efExitForwardTile init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20790
	)

	(method (init)
		(self createPoly: 120 1 98 80 99 118 178 118 178 1 120 1)
		(super init: &rest)
	)
)

(instance efExitForwardTile of ExitFeature
	(properties
		nextRoom 20510
	)

	(method (init)
		(self createPoly: 21 0 56 0 56 67 21 68 21 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20530
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20550
	)
)

