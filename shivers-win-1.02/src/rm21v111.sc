;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21111)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v111 0
)

(instance rm21v111 of ShiversRoom
	(properties
		picture 21111
	)

	(method (init)
		(proc951_16 141)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21110
	)

	(method (init)
		(self createPoly: 1 1 262 1 262 142 1 142 1 1)
		(super init: &rest)
	)
)

