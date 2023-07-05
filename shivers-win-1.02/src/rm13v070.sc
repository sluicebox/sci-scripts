;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13070)
(include sci.sh)
(use Main)

(public
	rm13v070 0
)

(instance rm13v070 of ShiversRoom
	(properties
		picture 13760
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
		nextRoom 13071
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13071
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13064
	)

	(method (init)
		(self createPoly: 62 142 89 112 89 30 166 30 166 113 190 142)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 13068
	)

	(method (init)
		(self createPoly: 62 142 62 3 88 29 88 112)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13060
	)

	(method (init)
		(self createPoly: 190 142 167 113 167 31 185 2)
		(super init: &rest)
	)
)

