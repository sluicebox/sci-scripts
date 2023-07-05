;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8351)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8351 0
)

(instance rm8351 of ExitRoom
	(properties
		picture 8351
		south 8348 ; rm8348
	)

	(method (init)
		(gGame changeScore: 1000)
		(SetFlag 600)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 10
		modNum 830
		nsLeft 28
		nsTop 48
		nsRight 620
		nsBottom 304
	)
)

