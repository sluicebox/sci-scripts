;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27183)
(include sci.sh)
(use Main)

(public
	rm27v183 0
)

(instance rm27v183 of ShiversRoom
	(properties
		picture 27183
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27193
	)

	(method (init)
		(self createPoly: 91 142 111 42 160 42 178 142 92 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27182
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27180
	)
)

