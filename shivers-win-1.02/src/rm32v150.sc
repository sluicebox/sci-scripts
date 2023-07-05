;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32150)
(include sci.sh)
(use Main)

(public
	rm32v150 0
)

(instance rm32v150 of ShiversRoom
	(properties
		picture 32150
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32160
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32200
	)

	(method (init)
		(self
			createPoly:
				57
				112
				191
				112
				191
				105
				183
				96
				164
				92
				164
				9
				84
				9
				84
				87
				59
				97
				58
				108
		)
		(super init: &rest)
	)
)

