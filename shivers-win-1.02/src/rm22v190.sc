;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22190)
(include sci.sh)
(use Main)

(public
	rm22v190 0
)

(instance rm22v190 of ShiversRoom
	(properties
		picture 22190
		invView 1
	)

	(method (init)
		(self initRoom: 212 235 94 119)
		(psOnShelf init:)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance psOnShelf of PotSpot
	(properties
		nsLeft 212
		nsTop 94
		nsRight 235
		nsBottom 119
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22200
	)
)

