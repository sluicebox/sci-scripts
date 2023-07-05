;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13349)
(include sci.sh)
(use Main)

(public
	rm13v349 0
)

(instance rm13v349 of ShiversRoom
	(properties
		picture 13980
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13347
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13348
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13339
	)

	(method (init)
		(self createPoly: 80 142 114 92 114 49 164 49 164 105 175 112 206 143)
		(super init: &rest)
	)
)

