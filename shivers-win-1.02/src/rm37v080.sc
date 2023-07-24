;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37080)
(include sci.sh)
(use Main)

(public
	rm37v080 0
)

(instance rm37v080 of ShiversRoom
	(properties
		picture 37080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37060
	)

	(method (init)
		(self
			createPoly: 200 144 102 125 100 69 111 69 113 34 154 26 216 10 211 141
		)
		(super init: &rest)
	)
)

