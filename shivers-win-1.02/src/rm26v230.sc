;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26230)
(include sci.sh)
(use Main)

(public
	rm26v230 0
)

(instance rm26v230 of ShiversRoom
	(properties
		picture 26230
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
		nextRoom 26220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26260
	)

	(method (init)
		(self
			createPoly: 46 144 58 124 58 23 158 23 166 18 183 18 183 140 189 145
		)
		(super init: &rest)
	)
)

