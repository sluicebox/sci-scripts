;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2270)
(include sci.sh)
(use Main)

(public
	rm2v27 0
)

(instance rm2v27 of ShiversRoom
	(properties
		picture 2160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 44
		nextRoom 2260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2560
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2590
	)

	(method (init)
		(self
			createPoly: 63 143 120 70 120 62 129 56 137 56 145 58 145 71 204 142
		)
		(super init: &rest)
	)
)

