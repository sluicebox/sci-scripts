;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27151)
(include sci.sh)
(use Main)

(public
	rm27v151 0
)

(instance rm27v151 of ShiversRoom
	(properties
		picture 27151
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
		nextRoom 27141
	)

	(method (init)
		(self createPoly: 58 142 76 98 76 4 184 4 184 99 204 142 58 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27150
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27152
	)
)

