;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21204)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v204 0
)

(instance rm21v204 of ShiversRoom
	(properties
		picture 21204
	)

	(method (init)
		(proc951_16 42)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21030
	)

	(method (init)
		(self createPoly: 1 1 200 1 200 136 1 136 1 1)
		(super init: &rest)
	)
)

