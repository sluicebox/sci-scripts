;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2790)
(include sci.sh)
(use Main)

(public
	rm2v79 0
)

(instance rm2v79 of ShiversRoom
	(properties
		picture 2060
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
		nextRoom 2800
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2800
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2070
	)

	(method (init)
		(self
			createPoly: 49 144 108 78 108 60 120 49 141 49 154 59 154 80 212 142
		)
		(super init: &rest)
	)
)

