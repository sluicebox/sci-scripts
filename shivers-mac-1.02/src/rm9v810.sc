;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9810)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v810 0
)

(instance rm9v810 of ShiversRoom
	(properties
		picture 9800
	)

	(method (init)
		(proc951_16 22)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 9040
	)

	(method (init)
		(self createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
	)
)

