;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6180)
(include sci.sh)
(use Main)

(public
	rm6v180 0
)

(instance rm6v180 of ShiversRoom
	(properties
		picture 6180
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6230
	)

	(method (init)
		(self
			createPoly: 120 139 125 109 125 33 77 33 77 94 20 119 20 144 120 143
		)
		(super init: &rest)
	)
)

