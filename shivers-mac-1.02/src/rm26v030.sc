;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26030)
(include sci.sh)
(use Main)

(public
	rm26v030 0
)

(instance rm26v030 of ShiversRoom
	(properties
		picture 26030
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26050
	)

	(method (init)
		(self createPoly: 102 144 81 92 21 92 21 143)
		(super init: &rest)
	)
)

