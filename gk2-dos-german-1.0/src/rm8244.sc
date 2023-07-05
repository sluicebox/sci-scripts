;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8244)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8244 0
)

(instance rm8244 of ExitRoom
	(properties
		picture 8244
		south 8243 ; rm8243
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 17
		modNum 820
		nsLeft 168
		nsTop 19
		nsRight 458
		nsBottom 333
	)
)

