;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9260)
(include sci.sh)
(use Main)

(public
	rm9v26 0
)

(instance rm9v26 of ShiversRoom
	(properties
		picture 9260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitToStair init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9270
	)

	(method (init)
		(self createPoly: 2 2 26 2 22 60 2 51 1 76 19 79 22 142 1 140)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9960
	)

	(method (init)
		(self
			createPoly: 149 48 148 53 88 53 72 56 80 75 145 72 141 94 94 125 224 131 185 93 185 47 149 48
		)
		(super init: &rest)
	)
)

(instance efExitToStair of ExitFeature
	(properties
		nextRoom 9240
	)

	(method (init)
		(self createPoly: 2 56 20 82 19 123 64 129 109 99 64 76 45 75 22 56)
		(super init: &rest)
	)
)

