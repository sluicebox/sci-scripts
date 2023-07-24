;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16510)
(include sci.sh)
(use Main)

(public
	rm16v510 0
)

(instance rm16v510 of ShiversRoom
	(properties
		picture 16510
	)

	(method (init)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 16500
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16710
	)

	(method (init)
		(self
			createPoly: 243 46 243 0 263 0 263 143 243 143 243 116 258 112 254 62
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16140
	)

	(method (init)
		(self createPoly: 42 143 243 47 254 62 258 112 243 117 243 143)
		(super init: &rest)
	)
)

