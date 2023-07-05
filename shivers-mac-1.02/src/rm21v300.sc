;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21300)
(include sci.sh)
(use Main)

(public
	rm21v300 0
)

(instance rm21v300 of ShiversRoom
	(properties
		picture 21300
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21380
	)

	(method (init)
		(self createPoly: 5 137 58 137 58 2 2 2 2 137)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21330
	)

	(method (init)
		(self createPoly: 229 142 230 129 240 129 240 2 262 2 262 143 231 143)
		(super init: &rest)
	)
)

