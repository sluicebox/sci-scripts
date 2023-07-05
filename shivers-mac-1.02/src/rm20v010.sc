;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20010)
(include sci.sh)
(use Main)

(public
	rm20v010 0
)

(instance rm20v010 of ShiversRoom
	(properties
		picture 20010
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
		nextRoom 20370
	)

	(method (init)
		(self
			createPoly: 113 0 113 46 167 127 240 115 240 84 208 50 190 0 114 0
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20060
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20040
	)
)

