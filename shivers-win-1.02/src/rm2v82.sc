;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2820)
(include sci.sh)
(use Main)

(public
	rm2v82 0
)

(instance rm2v82 of ShiversRoom
	(properties
		picture 2090
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
		nsRight 40
		nextRoom 2810
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2580
	)

	(method (init)
		(self
			createPoly: 48 142 118 77 118 65 128 52 145 52 149 62 149 77 226 142
		)
		(super init: &rest)
	)
)

