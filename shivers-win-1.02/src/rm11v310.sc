;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11310)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm11v310 0
)

(instance rm11v310 of ShiversRoom
	(properties
		picture 11310
		invView 2
	)

	(method (init)
		(self initRoom: 82 110 52 110)
		(vEggs init:)
		(psBehindEggs init:)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 11270
	)

	(method (init)
		(self
			createPoly: 60 142 52 52 76 53 81 120 184 121 195 54 215 54 209 144
		)
		(super init: &rest)
	)
)

(instance psBehindEggs of PotSpot
	(properties
		nsLeft 82
		nsTop 52
		nsRight 110
		nsBottom 110
	)
)

(instance vEggs of View
	(properties
		priority 25
		fixPriority 1
		view 11310
	)
)

