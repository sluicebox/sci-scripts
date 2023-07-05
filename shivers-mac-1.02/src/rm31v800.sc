;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31800)
(include sci.sh)
(use Main)
(use n951)

(public
	rm31v800 0
)

(instance rm31v800 of ShiversRoom
	(properties
		picture 31800
	)

	(method (init)
		(proc951_16 63)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31080
	)

	(method (init)
		(self createPoly: 0 0 263 0 263 143 0 143 0 1)
		(super init: &rest)
	)
)

