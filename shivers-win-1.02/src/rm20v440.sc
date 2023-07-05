;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20440)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm20v440 0
)

(instance rm20v440 of ShiversRoom
	(properties
		picture 20440
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			((View new:) view: 20441 cel: 5 setPri: 1 1 init:)
		else
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((View new:)
					view: 20440
					loop: temp0
					cel: [global540 (+ temp0 3)]
					setPri: 1 1
					init:
				)
			)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20500
	)

	(method (init)
		(self createPoly: 82 31 82 132 230 132 230 31 83 31)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20510
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20810
	)
)

