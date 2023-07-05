;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8243)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8243 0
)

(instance rm8243 of ExitRoom
	(properties
		picture 8243
		south 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(feat44 init:)
		(feat45 init:)
		(feat46 init:)
		(feat49 init:)
	)
)

(instance feat46 of GKFeature
	(properties
		nsLeft 24
		nsTop 96
		nsRight 136
		nsBottom 244
		BAD_SELECTOR 8246
	)
)

(instance feat49 of GKFeature
	(properties
		nsLeft 180
		nsTop 96
		nsRight 296
		nsBottom 244
		BAD_SELECTOR 8249
	)
)

(instance feat44 of GKFeature
	(properties
		nsLeft 336
		nsTop 96
		nsRight 456
		nsBottom 244
		BAD_SELECTOR 8244
	)
)

(instance feat45 of GKFeature
	(properties
		nsLeft 488
		nsTop 96
		nsRight 608
		nsBottom 244
		BAD_SELECTOR 8245
	)
)

