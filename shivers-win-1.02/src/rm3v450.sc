;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3450)
(include sci.sh)
(use Main)

(public
	rm3v450 0
)

(instance rm3v450 of ShiversRoom
	(properties
		picture 3450
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3340
	)

	(method (init)
		(self
			createPoly: 170 100 137 100 141 75 127 33 153 8 237 16 227 32 235 35 231 62 240 77 234 81 169 82
		)
		(super init: &rest)
	)
)

