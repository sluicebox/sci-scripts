;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14300)
(include sci.sh)
(use Main)

(public
	rm14v300 0
)

(instance rm14v300 of ShiversRoom
	(properties
		picture 14300
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
		nextRoom 14010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14310
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13345
	)

	(method (init)
		(self
			createPoly: 66 145 66 40 95 26 114 22 137 22 158 25 190 37 190 143
		)
		(super init: &rest)
	)
)

