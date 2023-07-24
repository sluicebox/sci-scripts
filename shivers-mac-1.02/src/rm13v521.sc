;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13521)
(include sci.sh)
(use Main)

(public
	rm13v521 0
)

(instance rm13v521 of ShiversRoom
	(properties
		picture 13920
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitPlaque init: 5)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13520
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 122 0 140)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13520
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13523
	)

	(method (init)
		(self
			createPoly: 107 116 107 55 118 39 133 34 146 34 163 43 168 55 168 115
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 13524
	)

	(method (init)
		(self createPoly: 54 143 20 122 0 140 0 143)
		(super init: &rest)
	)
)

