;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8311)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8311 0
)

(instance rm8311 of ExitRoom
	(properties
		picture 8311
		east 830 ; rm830
		south 830 ; rm830
	)

	(method (init)
		(super init: &rest)
		(painting init:)
		(glassCase init:)
		(deathCase init:)
	)
)

(instance painting of GKFeature
	(properties
		nsLeft 256
		nsTop 19
		nsRight 536
		nsBottom 235
		nextRoomNum 8340 ; rm8340
	)
)

(instance glassCase of GKFeature
	(properties
		nsLeft 250
		nsTop 273
		nsRight 538
		nsBottom 336
		nextRoomNum 8348 ; rm8348
	)
)

(instance deathCase of GKFeature
	(properties
		nsLeft 8
		nsTop 40
		nsRight 108
		nsBottom 321
		nextRoomNum 8347 ; rm8347
	)
)

