;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20330)
(include sci.sh)
(use Main)

(public
	rm20v330 0
)

(instance rm20v330 of ShiversRoom
	(properties
		picture 20330
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20310
	)

	(method (init)
		(self createPoly: 107 47 109 117 159 117 162 47 108 47)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20340
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20340
	)
)

