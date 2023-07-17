;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7312)
(include sci.sh)
(use Main)
(use GK2Room)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm7312 0
)

(instance rm7312 of GK2Room
	(properties
		picture 7312
	)

	(method (init)
		(if (== gPrevRoomNum 7301)
			(gEgo posn: 299 276 heading: 180)
		else
			(gEgo posn: 38 337 heading: 45)
		)
		(gEgo sel_737: init: setScaler: Scaler 101 30 403 272)
		(southWest init:)
		(cryptArea init:)
		(super init: &rest)
	)
)

(instance southWest of ExitFeature
	(properties
		nsRight 100
		nsBottom 340
		approachY 300
		BAD_SELECTOR 730
		BAD_SELECTOR 6
	)
)

(instance cryptArea of ExitFeature
	(properties
		x 389
		y 173
		BAD_SELECTOR 7301
		BAD_SELECTOR 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 365 123 358 224 421 223 418 124
					yourself:
				)
		)
		(super init: &rest)
	)
)

