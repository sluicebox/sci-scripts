;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27030)
(include sci.sh)
(use Main)

(public
	rm27v030 0
)

(instance rm27v030 of ShiversRoom
	(properties
		picture 27030
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
		nextRoom 27011
	)

	(method (init)
		(self createPoly: 93 142 109 34 172 34 179 141 94 141)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27031
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27031
	)
)

