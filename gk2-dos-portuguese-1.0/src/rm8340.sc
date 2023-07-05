;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8340)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8340 0
)

(instance rm8340 of ExitRoom
	(properties
		picture 8340
		south 8311 ; rm8311
	)

	(method (init)
		(picName init:)
		(super init: &rest)
		(picPlaque init:)
		(painting init:)
	)
)

(instance picName of GKFeature
	(properties
		noun 2
		modNum 830
		nsLeft 292
		nsTop 300
		nsRight 358
		nsBottom 324
	)
)

(instance picPlaque of GKFeature
	(properties
		nsLeft 10
		nsTop 266
		nsRight 60
		nsBottom 295
		BAD_SELECTOR 8341
	)
)

(instance painting of GKFeature
	(properties
		noun 1
		modNum 830
		nsLeft 114
		nsTop 28
		nsRight 538
		nsBottom 304
	)
)

