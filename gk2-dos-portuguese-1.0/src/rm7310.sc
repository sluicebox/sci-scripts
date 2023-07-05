;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7310)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm7310 0
)

(instance rm7310 of ExitRoom
	(properties
		picture 7310
		south 730 ; churchRm
	)

	(method (init)
		(churchDoor init:)
		(super init: &rest)
	)
)

(instance churchDoor of ExitFeature
	(properties
		nsLeft 180
		nsTop 33
		nsRight 338
		nsBottom 297
		sightAngle 40
		approachX 262
		approachY 302
		x 258
		y 165
		BAD_SELECTOR 8
	)

	(method (doVerb)
		(gCurRoom newRoom: 700) ; sqRm
	)
)

