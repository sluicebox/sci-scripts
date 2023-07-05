;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2180)
(include sci.sh)
(use Main)

(public
	rm2v18 0
)

(instance rm2v18 of ShiversRoom
	(properties
		picture 2030
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2640
	)

	(method (init)
		(self
			createPoly: 46 143 64 129 64 61 80 45 179 45 192 58 197 129 211 143
		)
		(super init: &rest)
	)
)

