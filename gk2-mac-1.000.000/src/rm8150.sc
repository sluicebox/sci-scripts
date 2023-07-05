;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8150)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8150 0
)

(instance rm8150 of ExitRoom
	(properties
		picture 8150
		south 8140 ; rm8140
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 33
		modNum 810
		nsLeft 14
		nsTop 12
		nsRight 616
		nsBottom 324
	)
)

