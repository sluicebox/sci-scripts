;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13350)
(include sci.sh)
(use Main)

(public
	rm13v350 0
)

(instance rm13v350 of ShiversRoom
	(properties
		picture 13750
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
		nextRoom 13351
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13351
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13346
	)

	(method (init)
		(self createPoly: 58 142 81 126 81 18 167 33 167 112 195 142)
		(super init: &rest)
	)
)

