;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1300)
(include sci.sh)
(use Main)

(public
	rm1v300 0
)

(instance rm1v300 of ShiversRoom
	(properties
		picture 1300
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1301
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1301
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1320
	)

	(method (init)
		(self createPoly: 0 72 93 59 141 30 197 19 197 85 240 142 0 142)
		(super init: &rest)
	)
)

