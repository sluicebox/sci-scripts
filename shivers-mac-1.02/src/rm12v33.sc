;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12330)
(include sci.sh)
(use Main)

(public
	rm12v33 0
)

(instance rm12v33 of ShiversRoom
	(properties
		picture 12330
	)

	(method (init)
		(efExitRight init: 1)
		(efPlaque init: 9)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12300
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 12590
	)

	(method (init)
		(self createPoly: 210 125 202 101 246 101 259 125)
		(super init: &rest)
	)
)

