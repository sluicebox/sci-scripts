;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11440)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v440 0
)

(instance rm11v440 of ShiversRoom
	(properties
		picture 11440
	)

	(method (init)
		(proc951_16 28)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties)

	(method (init)
		(self nextRoom: 11070 createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
	)
)

