;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7060)
(include sci.sh)
(use Main)

(public
	rm7v060 0
)

(instance rm7v060 of ShiversRoom
	(properties
		picture 7060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7300
	)

	(method (init)
		(self createPoly: 193 9 202 0 242 0 242 143 193 143)
		(super init: &rest)
	)
)

