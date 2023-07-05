;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15150)
(include sci.sh)
(use Main)

(public
	rm15v15 0
)

(instance rm15v15 of ShiversRoom
	(properties
		picture 15150
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
		nextRoom 15160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15120
	)

	(method (init)
		(self createPoly: 41 141 76 122 55 1 189 1 175 118 202 132 209 142)
		(super init: &rest)
	)
)

