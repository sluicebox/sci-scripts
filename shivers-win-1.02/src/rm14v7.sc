;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14070)
(include sci.sh)
(use Main)

(public
	rm14v7 0
)

(instance rm14v7 of ShiversRoom
	(properties
		picture 14070
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
		nextRoom 14080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14050
	)

	(method (init)
		(self
			createPoly:
				130
				144
				134
				105
				134
				53
				151
				49
				166
				55
				166
				105
				170
				144
				130
				144
		)
		(super init: &rest)
	)
)

