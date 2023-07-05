;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20690)
(include sci.sh)
(use Main)

(public
	rm20v690 0
)

(instance rm20v690 of ShiversRoom
	(properties
		picture 20690
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
		nextRoom 20780
	)

	(method (init)
		(self createPoly: 84 15 87 143 179 143 179 15 84 15)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20700
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20700
	)
)

