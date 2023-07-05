;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20380)
(include sci.sh)
(use Main)

(public
	rm20v380 0
)

(instance rm20v380 of ShiversRoom
	(properties
		picture 20380
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
		nextRoom 20840
	)

	(method (init)
		(self
			createPoly: 82 127 53 104 74 20 120 0 154 0 189 20 214 102 179 128
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20850
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20370
	)
)

