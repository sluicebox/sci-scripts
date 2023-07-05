;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm18v2 0
)

(instance rm18v2 of ShiversRoom
	(properties
		picture 18020
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18030
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

