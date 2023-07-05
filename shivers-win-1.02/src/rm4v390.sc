;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4390)
(include sci.sh)
(use Main)

(public
	rm4v390 0
)

(instance rm4v390 of ShiversRoom
	(properties
		picture 4180
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
		nextRoom 4380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4410
	)

	(method (init)
		(self createPoly: 78 123 103 99 103 54 155 54 159 98 186 122)
		(super init: &rest)
	)
)

