;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13361)
(include sci.sh)
(use Main)

(public
	rm13v361 0
)

(instance rm13v361 of ShiversRoom
	(properties
		picture 13670
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13362
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13360
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13365
	)

	(method (init)
		(self createPoly: 62 143 77 128 77 14 180 14 180 125 193 142)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13369
	)

	(method (init)
		(self createPoly: 180 126 180 15 225 0 225 142)
		(super init: &rest)
	)
)

