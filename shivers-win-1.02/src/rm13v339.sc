;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13339)
(include sci.sh)
(use Main)

(public
	rm13v339 0
)

(instance rm13v339 of ShiversRoom
	(properties
		picture 13740
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
		nextRoom 13338
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13336
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13335
	)

	(method (init)
		(self createPoly: 55 142 97 105 97 40 155 40 155 105 183 142)
		(super init: &rest)
	)
)

