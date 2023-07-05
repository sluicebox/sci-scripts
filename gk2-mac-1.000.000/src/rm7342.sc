;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7342)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm7342 0
)

(instance rm7342 of ExitRoom
	(properties
		picture 7342
		south 7301 ; rm7301
	)

	(method (init)
		(namePlate init:)
		(dudes init:)
		(super init: &rest)
	)
)

(instance dudes of GKFeature
	(properties
		noun 24
		modNum 730
		nsRight 640
		nsBottom 300
	)
)

(instance namePlate of GKFeature
	(properties
		noun 2
		modNum 730
		nsLeft 11
		nsTop 85
		nsRight 534
		nsBottom 136
	)
)

