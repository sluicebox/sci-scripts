;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13357)
(include sci.sh)
(use Main)

(public
	rm13v357 0
)

(instance rm13v357 of ShiversRoom
	(properties
		picture 13640
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13356
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13359
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13361
	)

	(method (init)
		(self createPoly: 66 143 94 111 94 31 165 31 165 109 189 142)
		(super init: &rest)
	)
)

