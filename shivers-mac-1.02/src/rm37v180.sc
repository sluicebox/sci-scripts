;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37180)
(include sci.sh)
(use Main)

(public
	rm37v180 0
)

(instance rm37v180 of ShiversRoom
	(properties
		picture 37180
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
		nextRoom 37170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37182
	)

	(method (init)
		(self createPoly: 95 102 99 66 119 66 123 101 116 104 101 104)
		(super init: &rest)
	)
)

