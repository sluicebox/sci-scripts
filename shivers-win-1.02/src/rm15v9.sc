;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15090)
(include sci.sh)
(use Main)

(public
	rm15v9 0
)

(instance rm15v9 of ShiversRoom
	(properties
		picture 15090
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15070
	)

	(method (init)
		(self createPoly: 77 142 113 125 113 88 150 88 150 125 180 142)
		(super init: &rest)
	)
)

