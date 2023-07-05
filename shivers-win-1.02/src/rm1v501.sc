;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1501)
(include sci.sh)
(use Main)

(public
	rm1v501 0
)

(instance rm1v501 of ShiversRoom
	(properties
		picture 1501
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1500
	)

	(method (init)
		(self createPoly: 1 1 90 1 90 142 1 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1503
	)
)

