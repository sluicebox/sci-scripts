;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23640)
(include sci.sh)
(use Main)

(public
	rm23v640 0
)

(instance rm23v640 of ShiversRoom
	(properties
		picture 23640
	)

	(method (init)
		(efExitForward init: 8)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 23630
	)
)

(instance efExitRight of ExitFeature ; UNUSED
	(properties
		nextRoom 23630
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23630
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

