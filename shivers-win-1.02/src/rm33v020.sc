;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33020)
(include sci.sh)
(use Main)

(public
	rm33v020 0
)

(instance rm33v020 of ShiversRoom
	(properties
		picture 33020
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33030
	)

	(method (init)
		(self createPoly: 35 142 99 36 172 36 234 142 35 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27124
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27124
	)
)

