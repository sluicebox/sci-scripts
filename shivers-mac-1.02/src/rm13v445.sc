;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13445)
(include sci.sh)
(use Main)

(public
	rm13v445 0
)

(instance rm13v445 of ShiversRoom
	(properties
		picture 13996
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
		nextRoom 13444
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13447
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13449
	)

	(method (init)
		(self createPoly: 55 142 99 100 99 42 154 42 154 101 183 143)
		(super init: &rest)
	)
)

