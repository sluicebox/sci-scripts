;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10121)
(include sci.sh)
(use Main)

(public
	rm10v121 0
)

(instance rm10v121 of ShiversRoom
	(properties
		picture 10121
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 0)
		(efExitUp init: 4)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10540
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10530
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10122
	)

	(method (init)
		(self createPoly: 138 97 80 115 66 86 123 69)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 20
		nsTop 0
		nsRight 243
		nsBottom 40
		nextRoom 10120
	)
)

