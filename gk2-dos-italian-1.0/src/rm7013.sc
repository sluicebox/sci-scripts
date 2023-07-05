;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7013)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm7013 0
)

(instance rm7013 of ExitRoom
	(properties
		picture 7013
		east 700 ; sqRm
		south 700 ; sqRm
		west 700 ; sqRm
	)

	(method (init)
		(postWindow init:)
		(postBuzzer init:)
		(if (!= gChapter 6)
			(postSign init:)
		)
		(super init: &rest)
	)
)

(instance postWindow of GKFeature
	(properties
		modNum 7030
		nsLeft 346
		nsTop 14
		nsRight 438
		nsBottom 160
		sightAngle 40
		approachX 392
		approachY 170
		x 392
		y 86
		BAD_SELECTOR 7030
	)
)

(instance postBuzzer of GKFeature
	(properties
		modNum 7030
		nsLeft 478
		nsTop 108
		nsRight 498
		nsBottom 136
		sightAngle 40
		approachX 490
		approachY 144
		x 488
		y 122
		BAD_SELECTOR 7030
	)
)

(instance postSign of GKFeature
	(properties
		noun 8
		modNum 7030
		nsLeft 492
		nsTop 43
		nsRight 550
		nsBottom 103
	)
)

