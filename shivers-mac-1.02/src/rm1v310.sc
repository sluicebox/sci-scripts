;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1310)
(include sci.sh)
(use Main)

(public
	rm1v310 0
)

(instance rm1v310 of ShiversRoom
	(properties
		picture 1310
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1311
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1311
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1320
	)

	(method (init)
		(self
			createPoly: 50 142 107 92 132 88 132 51 232 45 232 33 263 33 263 76 263 142
		)
		(super init: &rest)
	)
)

