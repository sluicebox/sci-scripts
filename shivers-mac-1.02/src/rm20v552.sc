;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20552)
(include sci.sh)
(use Main)

(public
	rm20v552 0
)

(instance rm20v552 of ShiversRoom
	(properties
		picture 20552
	)

	(method (init &tmp temp0)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 20550
	)

	(method (init)
		(self createPoly: 0 100 263 100 263 143 0 143)
		(super init: &rest)
	)
)

