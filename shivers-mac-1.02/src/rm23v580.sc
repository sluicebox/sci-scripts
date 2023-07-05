;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23580)
(include sci.sh)
(use Main)

(public
	rm23v580 0
)

(instance rm23v580 of ShiversRoom
	(properties
		picture 23580
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23570
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23590
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 23570
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

