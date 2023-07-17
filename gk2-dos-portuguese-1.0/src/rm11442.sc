;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11442)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Scaler)
(use Feature)

(public
	rm11442 0
)

(local
	local0
)

(instance rm11442 of GK2Room
	(properties
		modNum 1140
		picture 11442
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(gEgo
			posn: 319 275
			heading: 135
			setScaler: Scaler 71 59 326 278
			sel_737:
			init:
		)
		(super init: &rest)
		(doorExit init:)
		(balcony init:)
		(rightChairs init:)
		(leftChairs init:)
		(rightBox init:)
		(leftBox init:)
		(cond
			((and (not (IsFlag 764)) (IsFlag 802))
				(SetFlag 764)
				(SetFlag 741)
				(PlayScene 855)
			)
			((and (not (IsFlag 766)) (not (IsFlag 758)))
				(SetFlag 766)
				(PlayScene 853)
			)
			((and (IsFlag 758) (not (IsFlag 767)))
				(SetFlag 767)
				(PlayScene 854)
			)
		)
	)
)

(instance rightChairs of GKFeature
	(properties
		noun 17
		modNum 1140
		nsLeft 388
		nsTop 199
		nsRight 446
		nsBottom 217
		sightAngle 360
	)
)

(instance leftChairs of GKFeature
	(properties
		noun 17
		modNum 1140
		nsLeft 208
		nsTop 184
		nsRight 286
		nsBottom 220
		sightAngle 360
	)
)

(instance rightBox of GKFeature
	(properties
		noun 10
		modNum 1140
		nsLeft 551
		nsTop 194
		nsRight 628
		nsBottom 219
		sightAngle 360
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 741)
					(= noun 11)
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftBox of GKFeature
	(properties
		noun 10
		modNum 1140
		nsLeft 11
		nsTop 179
		nsRight 115
		nsBottom 225
		sightAngle 360
	)

	(method (doVerb theVerb)
		(rightBox doVerb: theVerb)
	)
)

(instance balcony of GKFeature
	(properties
		noun 15
		modNum 1140
		nsLeft 12
		nsTop 248
		nsRight 627
		nsBottom 348
		sightAngle 360
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (and local0 (IsFlag 741))
					(= noun 16)
				)
				(= local0 1)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		modNum 1140
		nsLeft 257
		nsTop 81
		nsRight 402
		nsBottom 210
		sightAngle 360
		x 316
		y 207
		BAD_SELECTOR 0
	)

	(method (doVerb)
		(PlayScene 1853 0 1140) ; centerHallRm
	)
)

