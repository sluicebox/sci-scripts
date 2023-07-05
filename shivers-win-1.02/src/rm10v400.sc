;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10400)
(include sci.sh)
(use Main)

(public
	rm10v400 0
)

(instance rm10v400 of ShiversRoom
	(properties
		picture 10400
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10170
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10410
	)

	(method (init)
		(self createPoly: 210 0 262 0 262 144 210 144 210 0)
		(super init: &rest)
	)
)

