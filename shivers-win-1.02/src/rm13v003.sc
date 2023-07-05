;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13003)
(include sci.sh)
(use Main)

(public
	rm13v003 0
)

(instance rm13v003 of ShiversRoom
	(properties
		picture 13020
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
		nextRoom 13002
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13002
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13001
	)

	(method (init)
		(self createPoly: 70 142 96 111 110 35 151 35 167 110 191 142)
		(super init: &rest)
	)
)

