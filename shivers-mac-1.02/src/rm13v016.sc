;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13016)
(include sci.sh)
(use Main)

(public
	rm13v016 0
)

(instance rm13v016 of ShiversRoom
	(properties
		picture 13140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13014
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13015
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13435
	)

	(method (init)
		(self createPoly: 111 96 111 47 156 47 156 96)
		(super init: &rest)
	)
)

