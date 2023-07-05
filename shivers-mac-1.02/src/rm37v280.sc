;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37280)
(include sci.sh)
(use Main)

(public
	rm37v280 0
)

(instance rm37v280 of ShiversRoom
	(properties
		picture 37280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37250
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 37291
	)

	(method (init)
		(self createPoly: 165 133 173 28 204 8 239 18 241 137 211 144 190 146)
		(super init: &rest)
	)
)

