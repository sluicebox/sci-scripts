;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4420)
(include sci.sh)
(use Main)

(public
	rm4v420 0
)

(instance rm4v420 of ShiversRoom
	(properties
		picture 4180
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4400
	)

	(method (init)
		(self createPoly: 78 123 103 99 103 54 155 54 159 98 186 122)
		(super init: &rest)
	)
)

