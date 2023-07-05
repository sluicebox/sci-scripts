;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29300)
(include sci.sh)
(use Main)

(public
	rm29v300 0
)

(instance rm29v300 of ShiversRoom
	(properties
		picture 29300
	)

	(method (init)
		(efExitDn init: 5)
		(super init: &rest)
	)
)

(instance efExitDn of ExitFeature
	(properties
		nextRoom 29010
	)

	(method (init)
		(self createPoly: 1 1 262 1 262 143 1 143 1 1)
		(super init: &rest)
	)
)

