;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30320)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v320 0
)

(instance rm30v320 of ShiversRoom
	(properties
		picture 30321
	)

	(method (init)
		(proc951_16 113)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 30290
	)

	(method (init)
		(self
			createPoly: 0 0 0 40 220 40 220 100 40 100 40 40 0 40 0 142 262 142 262 0 0 0
		)
		(super init: &rest)
	)
)

