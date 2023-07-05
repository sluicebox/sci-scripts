;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4060)
(include sci.sh)
(use Main)

(public
	rm4v060 0
)

(instance rm4v060 of ShiversRoom
	(properties
		picture 4040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4050
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4070
	)

	(method (init)
		(self createPoly: 210 0 262 0 262 142 210 142 210 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 4090
	)

	(method (init)
		(self
			createPoly: 89 111 121 78 124 62 130 59 140 62 143 72 143 77 174 111
		)
		(super init: &rest)
	)
)

