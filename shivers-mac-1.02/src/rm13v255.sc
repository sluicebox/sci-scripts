;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13255)
(include sci.sh)
(use Main)

(public
	rm13v255 0
)

(instance rm13v255 of ShiversRoom
	(properties
		picture 13430
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
		nextRoom 13254
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13254
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13301
	)

	(method (init)
		(self createPoly: 64 142 64 24 200 24 200 142)
		(super init: &rest)
	)
)

