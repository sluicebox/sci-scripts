;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2600)
(include sci.sh)
(use Main)

(public
	rm2v60 0
)

(instance rm2v60 of ShiversRoom
	(properties
		picture 2070
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
		nextRoom 2610
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2610
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2280
	)

	(method (init)
		(self
			createPoly: 41 142 104 89 104 61 116 48 141 48 164 77 165 98 218 143
		)
		(super init: &rest)
	)
)

