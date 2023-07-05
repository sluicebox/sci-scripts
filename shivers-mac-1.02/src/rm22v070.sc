;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22070)
(include sci.sh)
(use Main)

(public
	rm22v070 0
)

(instance rm22v070 of ShiversRoom
	(properties
		picture 22070
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22140
	)

	(method (init)
		(self createPoly: 79 32 79 134 193 134 203 45 130 2 90 2 79 31)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22050
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22080
	)
)

