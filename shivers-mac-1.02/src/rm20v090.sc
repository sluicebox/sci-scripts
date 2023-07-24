;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20090)
(include sci.sh)
(use Main)

(public
	rm20v090 0
)

(instance rm20v090 of ShiversRoom
	(properties
		picture 20090
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20130
	)

	(method (init)
		(self
			createPoly: 57 142 91 125 100 52 113 40 126 37 138 40 155 51 171 124 209 142 58 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20100
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20080
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 20710
	)

	(method (init)
		(self createPoly: 96 0 96 31 156 31 156 0 96 0)
		(super init: &rest)
	)
)

