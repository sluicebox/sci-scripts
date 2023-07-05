;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29080)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm29v080 0
)

(instance rm29v080 of ShiversRoom
	(properties
		picture 29080
		invView 1
	)

	(method (init)
		(if (IsFlag 68)
			(pSaucer init:)
			(pSaucerCover init:)
			(self initRoom: 80 110 76 112)
			(inShip init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29090
	)
)

(instance pSaucer of Prop
	(properties
		priority 10
		fixPriority 1
		view 29081
	)
)

(instance pSaucerCover of Prop
	(properties
		priority 150
		fixPriority 1
		view 29081
		loop 1
	)
)

(instance inShip of PotSpot
	(properties
		nsLeft 80
		nsTop 76
		nsRight 110
		nsBottom 112
	)
)

