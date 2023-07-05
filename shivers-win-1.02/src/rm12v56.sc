;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12560)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v56 0
)

(instance rm12v56 of ShiversRoom
	(properties
		picture 12560
	)

	(method (init)
		(proc951_16 33)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 12190
	)

	(method (init)
		(self createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
	)
)

