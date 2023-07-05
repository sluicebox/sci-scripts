;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1552)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v552 0
)

(instance rm1v552 of ShiversRoom
	(properties
		picture 1552
	)

	(method (init)
		(proc951_16 81)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 1550
	)

	(method (init)
		(self createPoly: 1 1 262 1 262 143 1 143)
		(super init: &rest)
	)
)

