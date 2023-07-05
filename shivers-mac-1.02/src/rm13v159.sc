;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13159)
(include sci.sh)
(use Main)

(public
	rm13v159 0
)

(instance rm13v159 of ShiversRoom
	(properties
		picture 13530
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13158
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13158
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13155
	)

	(method (init)
		(self createPoly: 44 142 89 135 89 8 205 8 205 135 210 142)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 13150
	)

	(method (init)
		(self createPoly: 38 143 38 0 88 8 88 134)
		(super init: &rest)
	)
)

