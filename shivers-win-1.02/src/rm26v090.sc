;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26090)
(include sci.sh)
(use Main)

(public
	rm26v090 0
)

(instance rm26v090 of ShiversRoom
	(properties
		picture 26090
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
		nextRoom 26080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26120
	)

	(method (init)
		(self
			createPoly: 214 100 243 96 243 43 38 53 27 57 21 62 21 144 215 143
		)
		(super init: &rest)
	)
)

