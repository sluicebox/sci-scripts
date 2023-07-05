;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8342)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8342 0
)

(instance rm8342 of ExitRoom
	(properties
		picture 8342
		south 830 ; rm830
	)

	(method (init)
		(super init: &rest)
		(feat44 init:)
		(feat45 init:)
		(feat46 init:)
		(feat49 init:)
	)
)

(instance feat44 of GKFeature
	(properties
		nsLeft 18
		nsTop 100
		nsRight 136
		nsBottom 244
		BAD_SELECTOR 8344
	)
)

(instance feat45 of GKFeature
	(properties
		nsLeft 176
		nsTop 96
		nsRight 292
		nsBottom 244
		BAD_SELECTOR 8345
	)
)

(instance feat46 of GKFeature
	(properties
		nsLeft 334
		nsTop 96
		nsRight 452
		nsBottom 244
		BAD_SELECTOR 8346
	)
)

(instance feat49 of GKFeature
	(properties
		nsLeft 488
		nsTop 96
		nsRight 608
		nsBottom 244
		BAD_SELECTOR 8349
	)
)

