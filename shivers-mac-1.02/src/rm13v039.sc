;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13039)
(include sci.sh)
(use Main)

(public
	rm13v039 0
)

(instance rm13v039 of ShiversRoom
	(properties
		picture 13490
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13037
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13038
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13035
	)

	(method (init)
		(self createPoly: 66 143 95 111 95 33 168 33 168 111 193 143)
		(super init: &rest)
	)
)

