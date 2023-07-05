;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16380)
(include sci.sh)
(use Main)

(public
	rm16v380 0
)

(instance rm16v380 of ShiversRoom
	(properties
		picture 16380
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
		nextRoom 16370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16370
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16330
	)

	(method (init)
		(self createPoly: 76 142 69 47 80 11 243 12 243 143)
		(super init: &rest)
	)
)

