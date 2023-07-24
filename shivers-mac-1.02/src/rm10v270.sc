;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10270)
(include sci.sh)
(use Main)

(public
	rm10v270 0
)

(instance rm10v270 of ShiversRoom
	(properties
		picture 10270
	)

	(method (init)
		(super init: &rest)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 7)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10280
	)

	(method (init)
		(self
			createPoly: 189 139 75 138 62 132 51 117 36 67 49 37 62 23 98 3 110 0 161 0 186 14 199 25 214 43 226 63 227 85 217 107 202 131
		)
		(super init: &rest)
	)
)

