;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8412)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Actor)

(public
	rm8412 0
)

(instance rm8412 of ExitRoom
	(properties
		picture 8412
		south 840 ; starnSeeRm
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 626)
			(ClearFlag 626)
			(if (IsFlag 576)
				(SetFlag 408)
				(PlayScene 499 0 8414) ; rm8412Topic
			else
				(SetFlag 576)
				(SetFlag 408)
				(gSoundManager sel_702: 1)
				(PlayScene 498 0 8414) ; rm8412Topic
			)
		else
			(if (IsFlag 408)
				(dall init: setScript: (FidgetScript new:))
			)
			(grace init: setScript: FidgetScript)
			(water init:)
			(cross init:)
		)
		(gSoundManager play: 0 841 840)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber south) (IsFlag 408))
			(PlayScene 502)
			(ClearFlag 408)
		)
		(if (== newRoomNumber 840) ; starnSeeRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance cross of GKFeature
	(properties
		nsLeft 292
		nsTop 52
		nsRight 318
		nsBottom 105
		BAD_SELECTOR 8440
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 603)
		)
		(super doVerb: theVerb)
	)
)

(instance water of GKFeature
	(properties
		nsLeft 152
		nsTop 139
		nsRight 454
		nsBottom 168
		BAD_SELECTOR 8413
	)
)

(instance grace of Prop
	(properties
		sightAngle 360
		x 235
		y 149
		view 21498
	)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)
)

(instance dall of Prop
	(properties
		sightAngle 360
		x 342
		y 83
		view 23504
	)

	(method (doVerb)
		(gCurRoom newRoom: 8414) ; rm8412Topic
	)
)

