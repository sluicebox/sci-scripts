;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8352)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8352 0
)

(instance rm8352 of ExitRoom
	(properties
		picture 8352
		south 8348 ; rm8348
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 13
		modNum 830
		nsLeft 28
		nsTop 48
		nsRight 620
		nsBottom 304
	)
)

