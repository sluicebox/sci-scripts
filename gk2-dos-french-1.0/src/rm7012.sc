;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7012)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm7012 0
)

(instance rm7012 of ExitRoom
	(properties
		picture 7012
		south 700 ; sqRm
		west 7011 ; rm7011
	)

	(method (init)
		(if (or (!= (gGk2Music number:) 700) (not (gGk2Music handle:)))
			(Lock 140 700 1) ; WAVE
			(gGk2Music number: 700 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		)
		(churchSign init:)
		(churchDoor init:)
		(super init: &rest)
	)
)

(instance churchSign of Feature
	(properties
		nsLeft 158
		nsTop 40
		nsRight 190
		nsBottom 175
		sightAngle 40
		approachX 176
		approachY 184
		x 174
		y 108
	)

	(method (doVerb)
		(gCurRoom newRoom: 7042)
	)
)

(instance churchDoor of ExitFeature
	(properties
		nsLeft 270
		nsTop 19
		nsRight 448
		nsBottom 300
		sightAngle 40
		approachX 364
		approachY 326
		x 358
		y 175
		exitDir 7
	)

	(method (doVerb)
		(gGk2Music fade:)
		(Lock 140 (gGk2Music number:) 0) ; WAVE
		(gCurRoom newRoom: 730) ; churchRm
	)
)

