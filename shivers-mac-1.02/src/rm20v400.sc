;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20400)
(include sci.sh)
(use Main)

(public
	rm20v400 0
)

(instance rm20v400 of ShiversRoom
	(properties
		picture 20400
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 20350
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20840
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20420
	)
)

