;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13407)
(include sci.sh)
(use Main)

(public
	rm13v407 0
)

(instance rm13v407 of ShiversRoom
	(properties
		picture 13380
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
		nextRoom 13406
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13406
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13411
	)

	(method (init)
		(self createPoly: 46 142 85 125 106 100 106 58 166 58 166 108 197 142)
		(super init: &rest)
	)
)

