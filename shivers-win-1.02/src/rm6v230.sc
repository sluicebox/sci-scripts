;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6230)
(include sci.sh)
(use Main)

(public
	rm6v230 0
)

(instance rm6v230 of ShiversRoom
	(properties
		picture 6230
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6210
	)

	(method (init)
		(self createPoly: 1 0 57 0 56 142 33 142 34 117 4 107 1 105 1 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6220
	)

	(method (init)
		(self createPoly: 262 0 198 0 198 142 263 142 262 0)
		(super init: &rest)
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

