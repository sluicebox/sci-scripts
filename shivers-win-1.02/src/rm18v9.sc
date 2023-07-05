;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18090)
(include sci.sh)
(use Main)

(public
	rm18v9 0
)

(instance rm18v9 of ShiversRoom
	(properties
		picture 18090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18100
	)

	(method (init)
		(self createPoly: 1 1 69 1 69 142 1 142 1 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18080
	)

	(method (init)
		(self createPoly: 223 143 230 70 243 1 262 1 262 143 223 143)
		(super init: &rest)
	)
)

