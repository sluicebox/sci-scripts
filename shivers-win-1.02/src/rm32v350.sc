;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32350)
(include sci.sh)
(use Main)

(public
	rm32v350 0
)

(instance rm32v350 of ShiversRoom
	(properties
		picture 32350
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32390
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32430
	)

	(method (init)
		(self
			createPoly: 177 55 177 96 220 129 220 136 52 136 52 125 84 97 84 53 177 53
		)
		(super init: &rest)
	)
)

