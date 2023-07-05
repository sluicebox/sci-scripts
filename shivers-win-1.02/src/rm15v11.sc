;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15110)
(include sci.sh)
(use Main)

(public
	rm15v11 0
)

(instance rm15v11 of ShiversRoom
	(properties
		picture 15110
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15090
	)

	(method (init)
		(self createPoly: 76 142 86 130 92 56 176 56 188 130 196 142)
		(super init: &rest)
	)
)

