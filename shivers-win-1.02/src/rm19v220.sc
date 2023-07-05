;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19220)
(include sci.sh)
(use Main)

(public
	rm19v220 0
)

(instance rm19v220 of ShiversRoom
	(properties
		picture 19220
		invView 1
	)

	(method (init)
		(self initRoom: 102 119 55 74)
		(onShelf init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19230
	)
)

(instance onShelf of PotSpot
	(properties
		nsLeft 102
		nsTop 55
		nsRight 119
		nsBottom 74
	)
)

