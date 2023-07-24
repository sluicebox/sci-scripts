;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11210)
(include sci.sh)
(use Main)

(public
	rm11v210 0
)

(instance rm11v210 of ShiversRoom
	(properties
		picture 11210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitGriffon init: 9)
		(efExitDoor init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11190
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 11220
	)

	(method (init)
		(self createPoly: 127 117 125 44 152 26 166 28 217 30 217 129)
		(super init: &rest)
	)
)

(instance efExitGriffon of ExitFeature
	(properties
		nextRoom 11500
	)

	(method (init)
		(self
			createPoly: 125 44 57 42 27 63 33 87 47 89 38 110 34 116 27 120 23 136 127 117
		)
		(super init: &rest)
	)
)

