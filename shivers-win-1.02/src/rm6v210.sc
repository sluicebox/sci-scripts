;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6210)
(include sci.sh)
(use Main)

(public
	rm6v210 0
)

(instance rm6v210 of ShiversRoom
	(properties
		picture 6210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6200
	)

	(method (init)
		(self createPoly: 210 145 175 115 172 21 21 21 21 136 85 137 81 143)
		(super init: &rest)
	)
)

