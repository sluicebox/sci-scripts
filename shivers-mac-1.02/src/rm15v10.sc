;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15100)
(include sci.sh)
(use Main)

(public
	rm15v10 0
)

(instance rm15v10 of ShiversRoom
	(properties
		picture 15100
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
		nextRoom 15090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15130
	)

	(method (init)
		(self
			createPoly: 32 142 55 109 105 105 108 51 155 51 155 104 205 107 211 121 220 125 220 142
		)
		(super init: &rest)
	)
)

