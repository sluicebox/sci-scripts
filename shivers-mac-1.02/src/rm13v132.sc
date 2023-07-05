;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13132)
(include sci.sh)
(use Main)

(public
	rm13v132 0
)

(instance rm13v132 of ShiversRoom
	(properties
		picture 13280
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
		nextRoom 13133
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13134
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13130
	)

	(method (init)
		(self createPoly: 68 143 81 127 81 32 169 32 169 110 196 142)
		(super init: &rest)
	)
)

