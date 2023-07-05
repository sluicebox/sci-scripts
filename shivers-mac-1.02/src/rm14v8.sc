;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14080)
(include sci.sh)
(use Main)

(public
	rm14v8 0
)

(instance rm14v8 of ShiversRoom
	(properties
		picture 14080
		invView 1
	)

	(method (init)
		(self initRoom: 188 218 15 41)
		(onShelf init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance onShelf of PotSpot
	(properties
		nsLeft 188
		nsTop 15
		nsRight 218
		nsBottom 41
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14220
	)

	(method (init)
		(self createPoly: 114 139 113 65 204 64 198 129)
		(super init: &rest)
	)
)

