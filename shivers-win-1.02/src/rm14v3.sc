;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14030)
(include sci.sh)
(use Main)

(public
	rm14v3 0
)

(instance rm14v3 of ShiversRoom
	(properties
		picture 14030
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14300
	)

	(method (init)
		(self
			createPoly:
				84
				142
				84
				30
				94
				24
				111
				19
				131
				19
				155
				25
				165
				33
				165
				138
				141
				142
		)
		(super init: &rest)
	)
)

