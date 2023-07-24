;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32360)
(include sci.sh)
(use Main)

(public
	rm32v360 0
)

(instance rm32v360 of ShiversRoom
	(properties
		picture 32036
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
		nextRoom 32340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32073
	)

	(method (init)
		(self
			createPoly: 80 142 80 63 139 38 189 38 189 125 177 125 177 143 80 143
		)
		(super init: &rest)
	)
)

