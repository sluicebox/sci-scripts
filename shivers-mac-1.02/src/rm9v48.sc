;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9480)
(include sci.sh)
(use Main)

(public
	rm9v48 0
)

(instance rm9v48 of ShiversRoom
	(properties
		picture 9480
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
		nextRoom 9490
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9490
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9200
	)

	(method (init)
		(self createPoly: 52 143 58 92 121 69 178 69 211 127 189 142)
		(super init: &rest)
	)
)

