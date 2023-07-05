;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15080)
(include sci.sh)
(use Main)

(public
	rm15v8 0
)

(instance rm15v8 of ShiversRoom
	(properties
		picture 15080
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
		nextRoom 15070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15100
	)

	(method (init)
		(self createPoly: 33 141 33 136 111 40 111 2 153 2 153 42 226 138)
		(super init: &rest)
	)
)

