;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21210)
(include sci.sh)
(use Main)

(public
	rm21v210 0
)

(instance rm21v210 of ShiversRoom
	(properties
		picture 21210
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21220
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21280
	)

	(method (init)
		(self createPoly: 77 141 100 48 100 4 157 4 157 48 167 141 77 141)
		(super init: &rest)
	)
)

