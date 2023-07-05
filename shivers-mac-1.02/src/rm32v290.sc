;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32290)
(include sci.sh)
(use Main)

(public
	rm32v290 0
)

(instance rm32v290 of ShiversRoom
	(properties
		picture 32290
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32300
	)

	(method (init)
		(self createPoly: 0 0 60 0 60 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32310
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 32310
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

