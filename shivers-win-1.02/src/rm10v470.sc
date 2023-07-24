;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10470)
(include sci.sh)
(use Main)

(public
	rm10v470 0
)

(instance rm10v470 of ShiversRoom
	(properties
		picture 10470
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10440
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10480
	)

	(method (init)
		(self
			createPoly: 78 138 96 115 81 104 70 86 70 70 76 48 104 33 125 30 150 29 164 34 182 50 188 57 190 68 192 84 186 101 175 107 165 112 182 138
		)
		(super init: &rest)
	)
)

