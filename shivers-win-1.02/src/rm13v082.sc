;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13082)
(include sci.sh)
(use Main)

(public
	rm13v082 0
)

(instance rm13v082 of ShiversRoom
	(properties
		picture 13880
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
		nextRoom 13083
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13084
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13086
	)

	(method (init)
		(self createPoly: 62 143 92 111 92 31 185 31 185 134 192 142)
		(super init: &rest)
	)
)

