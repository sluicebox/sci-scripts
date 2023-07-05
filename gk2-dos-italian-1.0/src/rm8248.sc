;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8248)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8248 0
)

(instance rm8248 of ExitRoom
	(properties
		picture 8248
		south 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		nsLeft 220
		nsTop 96
		nsRight 400
		nsBottom 264
		BAD_SELECTOR 8254
	)
)

