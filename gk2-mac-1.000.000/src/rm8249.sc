;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8249)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8249 0
)

(instance rm8249 of ExitRoom
	(properties
		picture 8249
		south 8243 ; rm8243
	)

	(method (init)
		(super init: &rest)
		(painting init:)
	)
)

(instance painting of GKFeature
	(properties
		noun 24
		modNum 820
		nsLeft 143
		nsTop 12
		nsRight 465
		nsBottom 334
	)
)

