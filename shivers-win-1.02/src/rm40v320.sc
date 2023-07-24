;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40320)
(include sci.sh)
(use Main)

(public
	rm40v320 0
)

(instance rm40v320 of ShiversRoom
	(properties
		picture 40220
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40300
	)

	(method (init)
		(self
			createPoly: 55 127 124 107 124 3 246 36 244 80 204 84 195 93 193 101 220 126 57 127
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40310
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40310
	)
)

