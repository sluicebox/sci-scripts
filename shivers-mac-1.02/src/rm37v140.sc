;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37140)
(include sci.sh)
(use Main)

(public
	rm37v140 0
)

(instance rm37v140 of ShiversRoom
	(properties
		picture 37140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37180
	)

	(method (init)
		(self createPoly: 113 122 106 72 106 45 177 45 179 122 183 137 105 137)
		(super init: &rest)
	)
)

