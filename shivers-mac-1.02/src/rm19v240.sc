;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19240)
(include sci.sh)
(use Main)

(public
	rm19v240 0
)

(instance rm19v240 of ShiversRoom
	(properties
		picture 19240
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
		nextRoom 19230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19320
	)

	(method (init)
		(self
			createPoly: 70 143 102 100 103 93 99 69 100 45 109 37 128 34 145 37 156 46 158 115 215 144
		)
		(super init: &rest)
	)
)

