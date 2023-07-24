;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20553)
(include sci.sh)
(use Main)

(public
	rm20v553 0
)

(instance rm20v553 of ShiversRoom
	(properties
		picture 20553
		invView 2
	)

	(method (init &tmp temp0)
		(self initRoom: 71 119 75 115)
		(inBox init:)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20550
	)

	(method (init)
		(self
			createPoly: 0 0 20 20 20 123 243 123 243 20 20 20 0 0 263 0 263 143 0 143
		)
		(super init: &rest)
	)
)

(instance inBox of PotSpot
	(properties
		nsLeft 71
		nsTop 75
		nsRight 119
		nsBottom 115
	)
)

