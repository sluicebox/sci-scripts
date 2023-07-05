;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31060)
(include sci.sh)
(use Main)

(public
	rm31v060 0
)

(instance rm31v060 of ShiversRoom
	(properties
		picture 31060
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31030
	)

	(method (init)
		(self createPoly: 200 0 262 0 262 144 200 144 200 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31050
	)

	(method (init)
		(self createPoly: 0 0 80 0 80 144 0 144 0 0)
		(super init: &rest)
	)
)

