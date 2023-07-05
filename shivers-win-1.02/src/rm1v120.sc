;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1120)
(include sci.sh)
(use Main)

(public
	rm1v120 0
)

(instance rm1v120 of ShiversRoom
	(properties
		picture 1120
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1130
	)

	(method (init)
		(self createPoly: 76 143 241 106 241 74 95 63 95 122 54 131)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1121
	)
)

