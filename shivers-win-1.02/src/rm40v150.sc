;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40150)
(include sci.sh)
(use Main)

(public
	rm40v150 0
)

(instance rm40v150 of ShiversRoom
	(properties
		picture 40100
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
		nextRoom 40130
	)

	(method (init)
		(self
			createPoly: 23 126 40 116 51 118 89 104 102 109 131 99 145 105 168 98 180 1 236 1 222 127 23 127 23 126
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40140
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40140
	)
)

