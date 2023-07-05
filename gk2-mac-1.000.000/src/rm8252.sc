;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8252)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8252 0
)

(instance rm8252 of ExitRoom
	(properties
		picture 8252
		south 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 13
		modNum 820
		nsLeft 28
		nsTop 48
		nsRight 620
		nsBottom 304
	)
)

