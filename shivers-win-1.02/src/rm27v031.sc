;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27031)
(include sci.sh)
(use Main)

(public
	rm27v031 0
)

(instance rm27v031 of ShiversRoom
	(properties
		picture 27031
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
		nextRoom 27043
	)

	(method (init)
		(self createPoly: 86 142 118 62 132 62 172 142 87 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27030
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27030
	)
)

