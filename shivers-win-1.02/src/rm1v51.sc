;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1051)
(include sci.sh)
(use Main)

(public
	rm1v51 0
)

(instance rm1v51 of ShiversRoom
	(properties
		picture 1051
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRoadRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1050
	)
)

(instance efExitRoadRight of ExitFeature
	(properties
		nextRoom 1060
	)

	(method (init)
		(self
			createPoly: 173 113 245 110 245 1 262 1 262 243 245 243 245 126 204 121
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1021
	)

	(method (init)
		(self
			createPoly: 86 90 203 122 206 143 133 143 145 128 80 104 33 96 12 97 12 25 15 14 20 8 45 7 74 15 86 28
		)
		(super init: &rest)
	)
)

