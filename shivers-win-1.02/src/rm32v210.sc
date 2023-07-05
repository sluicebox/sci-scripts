;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32210)
(include sci.sh)
(use Main)

(public
	rm32v210 0
)

(instance rm32v210 of ShiversRoom
	(properties
		picture 32210
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32450
	)

	(method (init)
		(self createPoly: 162 129 149 115 143 114 143 53 96 53 96 116 96 139)
		(super init: &rest)
	)
)

