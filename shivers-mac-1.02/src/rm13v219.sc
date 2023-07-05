;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13219)
(include sci.sh)
(use Main)

(public
	rm13v219 0
)

(instance rm13v219 of ShiversRoom
	(properties
		picture 13690
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13218
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13218
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 13195
	)

	(method (init)
		(self createPoly: 73 142 73 0 97 22 97 120)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13215
	)

	(method (init)
		(self createPoly: 98 120 98 23 188 23 188 121 227 143 73 143)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13191
	)

	(method (init)
		(self createPoly: 227 142 189 121 189 22 227 0)
		(super init: &rest)
	)
)

