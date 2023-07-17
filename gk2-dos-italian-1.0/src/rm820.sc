;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	rm820 0
)

(instance rm820 of ExitRoom ; "Herrenchiemsee Museum: Display Room 1"
	(properties
		noun 21
		picture 8201
		south 8122 ; rm8122
	)

	(method (init)
		(super init: &rest)
		(gEgo
			posn: 209 340
			heading: 45
			sel_737:
			init:
			setScaler: Scaler 92 54 363 263
		)
		(glassCase1 init:)
		(glassCase2 init:)
		(pic init:)
		(displayWall init:)
		(robe init:)
		(arti init:)
	)
)

(instance glassCase1 of GKFeature
	(properties
		nsLeft 224
		nsTop 187
		nsRight 296
		nsBottom 223
		sightAngle 360
		BAD_SELECTOR 8241
	)
)

(instance pic of GKFeature
	(properties
		nsLeft 244
		nsTop 84
		nsRight 296
		nsBottom 158
		sightAngle 360
		BAD_SELECTOR 8240
	)
)

(instance glassCase2 of GKFeature
	(properties
		nsLeft 40
		nsTop 204
		nsRight 86
		nsBottom 264
		sightAngle 360
		BAD_SELECTOR 8202
	)
)

(instance displayWall of GKFeature
	(properties
		nsLeft 428
		nsTop 91
		nsRight 628
		nsBottom 285
		sightAngle 360
		BAD_SELECTOR 8243
	)
)

(instance robe of GKFeature
	(properties
		nsLeft 100
		nsTop 146
		nsRight 190
		nsBottom 220
		sightAngle 360
		BAD_SELECTOR 8247
	)
)

(instance arti of GKFeature
	(properties
		nsLeft 294
		nsTop 124
		nsRight 340
		nsBottom 220
		sightAngle 360
		BAD_SELECTOR 8248
	)
)

