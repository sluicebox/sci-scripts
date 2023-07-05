;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16350)
(include sci.sh)
(use Main)

(public
	rm16v350 0
)

(instance rm16v350 of ShiversRoom
	(properties
		picture 16350
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16340
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18010
	)

	(method (init)
		(self createPoly: 52 144 54 65 69 30 158 30 175 54 182 143)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 16359
	)
)

