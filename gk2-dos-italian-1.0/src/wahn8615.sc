;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8615)
(include sci.sh)
(use northExit)
(use Feature)

(public
	wahn8615 0
)

(instance wahn8615 of ExitRoom
	(properties
		picture 8615
		south 8604 ; wahnDisp4Rm
	)

	(method (init)
		(super init: &rest)
		(leftPic init:)
		(rightPic init:)
	)
)

(instance rightPic of GKFeature
	(properties
		nsLeft 270
		nsRight 454
		nsBottom 108
		BAD_SELECTOR 8616
	)
)

(instance leftPic of GKFeature
	(properties
		nsLeft 142
		nsTop 19
		nsRight 240
		nsBottom 122
		BAD_SELECTOR 8617
	)
)

