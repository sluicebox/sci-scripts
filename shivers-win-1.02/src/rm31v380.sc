;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31380)
(include sci.sh)
(use Main)

(public
	rm31v380 0
)

(instance rm31v380 of ShiversRoom
	(properties
		picture 31380
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31340
	)

	(method (init)
		(self createPoly: 111 54 111 117 151 117 151 54 111 54)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31390
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31390
	)
)

