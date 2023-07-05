;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12090)
(include sci.sh)
(use Main)

(public
	rm12v09 0
)

(instance rm12v09 of ShiversRoom
	(properties
		picture 12090
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12100
	)

	(method (init)
		(self createPoly: 87 142 88 116 104 102 104 61 160 61 160 101 206 145)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 12580
	)

	(method (init)
		(self createPoly: 85 118 78 125 56 108 53 102 58 97 69 100 87 113)
		(super init: &rest)
	)
)

