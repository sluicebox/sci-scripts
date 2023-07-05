;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	srExtWallRoom 0
)

(instance srExtWallRoom of ExitRoom
	(properties
		picture 1701
		west 1721 ; rm1721
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 160) ; srSecretRoom
			(gGk2Music fade: 0 30 30 1)
			(Lock rsAUDIO 160 0)
			(PlayScene 147)
		)
		(Lock 140 170 1) ; WAVE
		(gGk2Music number: 170 setLoop: -1 play:)
		(wallExit init:)
		(castle init:)
		(roses init:)
		(gEgo
			posn: 295 329
			heading: 225
			BAD_SELECTOR:
			setScaler: Scaler 92 77 342 292
			init:
		)
	)

	(method (newRoom)
		(gGk2Music fade:)
		(Lock 140 170 0) ; WAVE
		(super newRoom: &rest)
	)
)

(instance wallExit of ExitFeature
	(properties
		nsLeft 242
		nsTop 81
		nsRight 374
		nsBottom 278
		sightAngle 360
		approachX 320
		BAD_SELECTOR 160
		BAD_SELECTOR 0
	)
)

(instance castle of Feature
	(properties
		noun 9
		modNum 160
		sightAngle 360
		x 134
		y 158
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 294 226 42 269 1 0 1 0 315
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance roses of GKFeature
	(properties
		modNum 160
		sightAngle 360
		approachX 530
		approachY 250
		x 530
		y 260
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 508 131 439 235 474 269 540 249 554 142
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(= noun (= BAD_SELECTOR 0))
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 646)
						(= noun 5)
					)
					((IsFlag 607)
						(= BAD_SELECTOR 426)
						(SetFlag 646)
						(gEgo heading: 135)
						(gEgo get: 38) ; invFourRoses
					)
					(else
						(= noun 3)
					)
				)
			)
		)
		(super doVerb: theVerb)
	)
)

