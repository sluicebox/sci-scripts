;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1342)
(include sci.sh)
(use Main)

(public
	rm1v342 0
)

(instance rm1v342 of ShiversRoom
	(properties
		picture 1342
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
		nextRoom 1330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1343
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1311
	)

	(method (init)
		(self createPoly: 0 115 51 90 101 94 99 57 157 59 231 109 243 142 0 142)
		(super init: &rest)
	)
)

