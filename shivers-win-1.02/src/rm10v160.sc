;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10160)
(include sci.sh)
(use Main)

(public
	rm10v160 0
)

(instance rm10v160 of ShiversRoom
	(properties
		picture 10160
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10490
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10170
	)

	(method (init)
		(self createPoly: 83 127 82 20 109 9 127 6 150 8 178 15 177 127)
		(super init: &rest)
	)
)

