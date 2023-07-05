;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8251)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8251 0
)

(instance rm8251 of ExitRoom
	(properties
		picture 8251
		south 8241 ; rm8241
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 25
		modNum 820
		nsLeft 28
		nsTop 48
		nsRight 620
		nsBottom 304
	)
)

