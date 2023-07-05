;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32240)
(include sci.sh)
(use Main)

(public
	rm32v240 0
)

(instance rm32v240 of ShiversRoom
	(properties
		picture 32240
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32250
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 32270
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

