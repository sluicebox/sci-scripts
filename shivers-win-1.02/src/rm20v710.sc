;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20710)
(include sci.sh)
(use Main)

(public
	rm20v710 0
)

(instance rm20v710 of ShiversRoom
	(properties
		picture 20710
	)

	(method (init)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 20090
	)

	(method (init)
		(self createPoly: 0 111 0 142 262 142 262 111 0 111)
		(super init: &rest)
	)
)

