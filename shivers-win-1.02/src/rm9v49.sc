;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9490)
(include sci.sh)
(use Main)

(public
	rm9v49 0
)

(instance rm9v49 of ShiversRoom
	(properties
		picture 9490
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9480
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9480
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9510
	)

	(method (init)
		(self createPoly: 48 143 15 4 173 97 229 143)
		(super init: &rest)
	)
)

