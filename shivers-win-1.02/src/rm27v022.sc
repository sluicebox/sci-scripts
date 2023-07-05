;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27022)
(include sci.sh)
(use Main)

(public
	rm27v022 0
)

(instance rm27v022 of ShiversRoom
	(properties
		picture 27022
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
		nextRoom 27012
	)

	(method (init)
		(self createPoly: 103 142 127 42 169 42 191 142 104 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27021
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27023
	)
)

