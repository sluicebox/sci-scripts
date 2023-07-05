;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32270)
(include sci.sh)
(use Main)

(public
	rm32v270 0
)

(instance rm32v270 of ShiversRoom
	(properties
		picture 32270
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32280
	)

	(method (init)
		(self createPoly: 166 55 105 55 105 131 105 139 181 139 170 130 170 55)
		(super init: &rest)
	)
)

