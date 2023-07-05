;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1122)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v122 0
)

(instance rm1v122 of ShiversRoom
	(properties
		picture 1122
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForwardRight init: 1)
		(proc951_16 84)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1123
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1120
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 1120
	)

	(method (init)
		(self createPoly: 212 141 242 141 242 64 195 64 193 84)
		(super init: &rest)
	)
)

