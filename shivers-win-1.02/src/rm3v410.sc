;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3410)
(include sci.sh)
(use Main)

(public
	rm3v410 0
)

(instance rm3v410 of ShiversRoom
	(properties
		picture 3410
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
		nextRoom 3400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4010
	)

	(method (init)
		(self createPoly: 20 140 121 53 122 32 142 32 142 53 240 140 20 140)
		(super init: &rest)
	)
)

