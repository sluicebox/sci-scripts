;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8350)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8350 0
)

(instance rm8350 of ExitRoom
	(properties
		picture 8350
		south 8348 ; rm8348
	)

	(method (init)
		(super init: &rest)
		(gGame changeScore: 999)
		(SetFlag 599)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 9
		modNum 830
		nsLeft 28
		nsTop 48
		nsRight 620
		nsBottom 304
	)
)

