;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12040)
(include sci.sh)
(use Main)

(public
	rm12v04 0
)

(instance rm12v04 of ShiversRoom
	(properties
		picture 12040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12320
	)

	(method (init)
		(self
			createPoly: 97 145 101 29 132 11 168 6 198 9 226 22 243 41 244 142
		)
		(super init: &rest)
	)
)

