;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13440)
(include sci.sh)
(use Main)

(public
	rm13v440 0
)

(instance rm13v440 of ShiversRoom
	(properties
		picture 13260
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
		nextRoom 13441
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13441
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13276
	)

	(method (init)
		(self createPoly: 64 142 64 22 199 22 199 142)
		(super init: &rest)
	)
)

