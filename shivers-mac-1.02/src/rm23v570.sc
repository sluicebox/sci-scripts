;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23570)
(include sci.sh)
(use Main)

(public
	rm23v570 0
)

(instance rm23v570 of ShiversRoom
	(properties
		picture 23570
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23550
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23530
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23500
	)

	(method (init)
		(self
			createPoly: 96 133 99 127 91 48 95 30 107 17 131 8 146 8 162 12 164 19 166 32 168 88 166 124 173 130 98 129
		)
		(super init: &rest)
	)
)

