;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8200)
(include sci.sh)
(use Main)

(public
	rm8v200 0
)

(instance rm8v200 of ShiversRoom
	(properties
		picture 8200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8140
	)

	(method (init)
		(self createPoly: 31 143 77 122 77 13 196 13 196 121 214 141)
		(super init: &rest)
	)
)

