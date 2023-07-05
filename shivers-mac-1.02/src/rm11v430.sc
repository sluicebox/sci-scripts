;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11430)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v430 0
)

(instance rm11v430 of ShiversRoom
	(properties
		picture 11430
	)

	(method (init)
		(proc951_16 24)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties)

	(method (init)
		(self nextRoom: 11060 createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
	)
)

