;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16210)
(include sci.sh)
(use Main)

(public
	rm16v210 0
)

(instance rm16v210 of ShiversRoom
	(properties
		picture 16210
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
		nextRoom 16220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16230
	)

	(method (init)
		(self createPoly: 222 142 205 134 206 90 244 84 244 8 22 8 22 112 0 143)
		(super init: &rest)
	)
)

