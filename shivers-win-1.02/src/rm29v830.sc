;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29830)
(include sci.sh)
(use Main)

(public
	rm29v830 0
)

(instance rm29v830 of ShiversRoom
	(properties
		picture 29830
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29120
	)

	(method (init)
		(self createPoly: 0 0 263 0 263 143 0 143 0 1)
		(super init: &rest)
	)
)

