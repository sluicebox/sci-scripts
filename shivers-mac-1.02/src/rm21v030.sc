;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21030)
(include sci.sh)
(use Main)

(public
	rm21v030 0
)

(instance rm21v030 of ShiversRoom
	(properties
		picture 21030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForwardLeftPlaque init: 3)
		(efExitForwardLeftScull init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21440
	)
)

(instance efExitForwardLeftPlaque of ExitFeature
	(properties
		nextRoom 21204
	)

	(method (init)
		(self
			createPoly: 84 130 83 123 76 119 76 100 79 100 79 91 70 84 49 84 49 124 45 129 45 132 45 133 61 136 71 134 82 130
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeftScull of ExitFeature
	(properties
		nextRoom 21205
	)

	(method (init)
		(self createPoly: 37 123 37 112 23 112 23 124 37 124)
		(super init: &rest)
	)
)

