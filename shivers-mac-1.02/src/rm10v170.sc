;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10170)
(include sci.sh)
(use Main)

(public
	rm10v170 0
)

(instance rm10v170 of ShiversRoom
	(properties
		picture 10170
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 6)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10180
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 143 0 143 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10410
	)
)

