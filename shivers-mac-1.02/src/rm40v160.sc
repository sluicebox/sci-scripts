;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40160)
(include sci.sh)
(use Main)

(public
	rm40v160 0
)

(instance rm40v160 of ShiversRoom
	(properties
		picture 40270
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
		nextRoom 40180
	)

	(method (init)
		(self createPoly: 87 127 233 127 140 75 140 1 80 1 88 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40170
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40170
	)
)

