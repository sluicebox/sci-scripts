;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24800)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v800 0
)

(instance rm24v800 of ShiversRoom
	(properties
		picture 24800
	)

	(method (init)
		(proc951_16 58)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 24240
	)

	(method (init)
		(self createPoly: 0 0 262 0 262 143 0 143 0)
		(super init: &rest)
	)
)

