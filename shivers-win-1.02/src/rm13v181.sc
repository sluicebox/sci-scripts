;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13181)
(include sci.sh)
(use Main)

(public
	rm13v181 0
)

(instance rm13v181 of ShiversRoom
	(properties
		picture 13710
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
		nextRoom 13182
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13179
	)

	(method (init)
		(self createPoly: 76 142 112 105 112 42 168 42 168 107 226 142)
		(super init: &rest)
	)
)

