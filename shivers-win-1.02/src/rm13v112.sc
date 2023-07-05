;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13112)
(include sci.sh)
(use Main)

(public
	rm13v112 0
)

(instance rm13v112 of ShiversRoom
	(properties
		picture 13320
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
		nextRoom 13113
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13113
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13114
	)

	(method (init)
		(self createPoly: 54 142 72 126 72 18 198 18 197 142)
		(super init: &rest)
	)
)

