;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31160)
(include sci.sh)
(use Main)

(public
	rm31v160 0
)

(instance rm31v160 of ShiversRoom
	(properties
		picture 31160
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31140
	)

	(method (init)
		(self createPoly: 29 14 28 129 231 129 231 13 29 13)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31420
	)
)

