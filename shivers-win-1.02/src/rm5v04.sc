;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5040)
(include sci.sh)
(use Main)

(public
	rm5v04 0
)

(instance rm5v04 of ShiversRoom
	(properties
		picture 5040
	)

	(method (init)
		(efExitLookUp init: 4)
		(super init: &rest)
	)
)

(instance efExitLookUp of ExitFeature
	(properties)

	(method (init)
		(self nextRoom: 5030)
		(self createPoly: 0 25 264 25 264 0 0 0)
		(super init: &rest)
	)
)

