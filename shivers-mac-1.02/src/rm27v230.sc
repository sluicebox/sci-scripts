;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27230)
(include sci.sh)
(use Main)

(public
	rm27v230 0
)

(instance rm27v230 of ShiversRoom
	(properties
		picture 27230
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27220
	)

	(method (init)
		(self createPoly: 94 142 111 42 147 42 179 142 95 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27233
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27231
	)
)

