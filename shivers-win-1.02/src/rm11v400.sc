;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11400)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v400 0
)

(instance rm11v400 of ShiversRoom
	(properties
		picture 11400
	)

	(method (init)
		(proc951_16 25)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 11500
	)

	(method (init)
		(self createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
	)
)

