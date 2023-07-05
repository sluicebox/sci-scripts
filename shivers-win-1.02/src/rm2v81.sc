;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2810)
(include sci.sh)
(use Main)

(public
	rm2v81 0
)

(instance rm2v81 of ShiversRoom
	(properties
		picture 2080
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2830
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 222
		nextRoom 2820
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2850
	)

	(method (init)
		(self
			createPoly: 36 142 114 76 114 57 119 50 137 50 145 66 145 76 214 142
		)
		(super init: &rest)
	)
)

