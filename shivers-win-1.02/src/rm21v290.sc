;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21290)
(include sci.sh)
(use Main)

(public
	rm21v290 0
)

(instance rm21v290 of ShiversRoom
	(properties
		picture 21290
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21300
	)

	(method (init)
		(self createPoly: 63 0 63 28 63 123 209 123 209 3 209 0 64 0)
		(super init: &rest)
	)
)

