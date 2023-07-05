;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8440)
(include sci.sh)
(use Main)

(public
	rm8v440 0
)

(instance rm8v440 of ShiversRoom
	(properties
		picture 8440
	)

	(method (init)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8430
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

