;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9960)
(include sci.sh)
(use Main)

(public
	rm9v96 0
)

(instance rm9v96 of ShiversRoom
	(properties
		picture 9960
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitDesk init: 3)
		(super init: &rest)
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 9180
	)

	(method (init)
		(self createPoly: 80 78 69 54 93 50 119 50 148 55 141 78 80 78)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9190
	)

	(method (init)
		(self createPoly: 191 54 192 92 135 113 248 130 241 99 226 97 228 52)
		(super init: &rest)
	)
)

