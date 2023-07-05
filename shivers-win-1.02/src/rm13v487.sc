;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13487)
(include sci.sh)
(use Main)

(public
	rm13v487 0
)

(instance rm13v487 of ShiversRoom
	(properties
		picture 13520
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
		nextRoom 13486
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13489
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13491
	)

	(method (init)
		(self createPoly: 67 143 95 112 95 31 169 31 169 111 195 143)
		(super init: &rest)
	)
)

