;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2300)
(include sci.sh)
(use Main)

(public
	rm2v30 0
)

(instance rm2v30 of ShiversRoom
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
		nextRoom 2630
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 223
		nextRoom 2310
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2600
	)

	(method (init)
		(self
			createPoly: 49 144 108 78 108 60 120 49 141 49 154 59 154 80 212 142
		)
		(super init: &rest)
	)
)

