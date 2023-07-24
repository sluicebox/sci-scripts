;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23260)
(include sci.sh)
(use Main)

(public
	rm23v260 0
)

(instance rm23v260 of ShiversRoom
	(properties
		picture 23260
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23240
	)

	(method (init)
		(self
			createPoly: 52 37 72 134 186 134 227 24 226 0 185 0 149 35 52 35 52 37
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23930
	)

	(method (init)
		(self createPoly: 233 47 241 52 241 53 229 60 220 53 232 46 234 47)
		(super init: &rest)
	)
)

