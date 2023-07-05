;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13433)
(include sci.sh)
(use Main)

(public
	rm13v433 0
)

(instance rm13v433 of ShiversRoom
	(properties
		picture 13250
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
		nextRoom 13432
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13432
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13434
	)

	(method (init)
		(self createPoly: 67 142 99 106 99 35 165 35 165 107 194 142)
		(super init: &rest)
	)
)

