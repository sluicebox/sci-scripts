;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23420)
(include sci.sh)
(use Main)

(public
	rm23v420 0
)

(instance rm23v420 of ShiversRoom
	(properties
		picture 23420
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23430
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 23400
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

