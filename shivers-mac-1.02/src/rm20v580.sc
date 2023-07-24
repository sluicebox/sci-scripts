;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20580)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm20v580 0
)

(instance rm20v580 of ShiversRoom
	(properties
		picture 20580
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			(= picture 20581)
		else
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((View new:)
					view: 20580
					y: 143
					loop: temp0
					cel: [global540 temp0]
					setPri: 1 1
					init:
				)
			)
		)
		(efExitTable init: 3)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20585
	)

	(method (init)
		(self createPoly: 78 2 82 128 203 128 203 2 78 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20600
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20610
	)

	(method (init)
		(self
			createPoly: 25 143 25 117 12 125 12 75 25 75 25 0 1 0 1 141 0 143 25 143
		)
		(super init: &rest)
	)
)

(instance efExitTable of ExitFeature
	(properties
		nextRoom 20550
	)

	(method (init)
		(self createPoly: 13 122 13 77 75 77 13 122)
		(super init: &rest)
	)
)

