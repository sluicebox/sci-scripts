;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37210)
(include sci.sh)
(use Main)

(public
	rm37v210 0
)

(instance rm37v210 of ShiversRoom
	(properties
		picture 37210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37130
	)

	(method (init)
		(self createPoly: 54 126 113 55 142 54 172 82 212 129)
		(super init: &rest)
	)
)

