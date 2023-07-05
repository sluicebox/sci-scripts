;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13518)
(include sci.sh)
(use Main)

(public
	rm13v518 0
)

(instance rm13v518 of ShiversRoom
	(properties
		picture 13950
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
		nextRoom 13519
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13519
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13000
	)

	(method (init)
		(self
			createPoly: 108 15 97 74 24 127 24 142 221 142 157 74 149 15 108 15
		)
		(super init: &rest)
	)
)

