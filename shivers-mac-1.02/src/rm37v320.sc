;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37320)
(include sci.sh)
(use Main)

(public
	rm37v320 0
)

(instance rm37v320 of ShiversRoom
	(properties
		picture 37320
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37300
	)

	(method (init)
		(self createPoly: 99 132 99 35 160 35 160 130)
		(super init: &rest)
	)
)

