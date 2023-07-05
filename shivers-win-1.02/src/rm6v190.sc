;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6190)
(include sci.sh)
(use Main)

(public
	rm6v190 0
)

(instance rm6v190 of ShiversRoom
	(properties
		picture 6190
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6180
	)
)

(instance efExitForward of ExitFeature ; UNUSED
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

