;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4210)
(include sci.sh)
(use Main)

(public
	rm4v210 0
)

(instance rm4v210 of ShiversRoom
	(properties
		picture 4080
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
		nextRoom 4200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4240
	)

	(method (init)
		(self createPoly: 63 135 97 100 98 40 176 39 178 104 203 132)
		(super init: &rest)
	)
)

