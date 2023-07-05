;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13362)
(include sci.sh)
(use Main)

(public
	rm13v362 0
)

(instance rm13v362 of ShiversRoom
	(properties
		picture 13680
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13361
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13442
	)

	(method (init)
		(self createPoly: 63 142 108 94 108 47 158 47 157 98 191 142)
		(super init: &rest)
	)
)

