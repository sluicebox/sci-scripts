;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4000)
(include sci.sh)
(use Main)

(public
	rm4v000 0
)

(instance rm4v000 of ShiversRoom
	(properties
		picture 4230
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
		nextRoom 4010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3400
	)

	(method (init)
		(self
			createPoly: 101 105 95 82 95 67 96 49 110 31 122 22 132 20 151 27 168 40 175 57 175 73 172 99 167 106
		)
		(super init: &rest)
	)
)

