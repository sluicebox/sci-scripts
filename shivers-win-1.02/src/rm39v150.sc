;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39150)
(include sci.sh)
(use Main)

(public
	rm39v150 0
)

(instance rm39v150 of ShiversRoom
	(properties
		picture 39150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39160
	)
)

(instance efForward of ExitFeature ; UNUSED
	(properties
		nextRoom 39100
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

