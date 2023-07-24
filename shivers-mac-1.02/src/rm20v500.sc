;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20500)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm20v500 0
)

(instance rm20v500 of ShiversRoom
	(properties
		picture 20500
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			(= picture 20501)
		else
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((View new:)
					view: 20500
					y: 143
					loop: temp0
					cel: [global540 (+ temp0 3)]
					setPri: 1 1
					init:
				)
			)
		)
		(efExitTile init: 3)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20800
	)

	(method (init)
		(self createPoly: 45 22 45 132 170 132 170 22 45 22)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20550
	)

	(method (init)
		(self
			createPoly: 264 0 225 0 225 70 191 70 191 75 225 89 225 143 264 143 264 0
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20530
	)
)

(instance efExitTile of ExitFeature
	(properties
		nextRoom 20610
	)

	(method (init)
		(self createPoly: 215 67 182 67 182 2 218 2 218 67)
		(super init: &rest)
	)
)

