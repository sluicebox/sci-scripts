;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32060)
(include sci.sh)
(use Main)

(public
	rm32v060 0
)

(instance rm32v060 of ShiversRoom
	(properties
		picture 32060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32030
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 32040
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

