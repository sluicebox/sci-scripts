;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8604)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	wahnDisp4Rm 0
)

(instance wahnDisp4Rm of ExitRoom
	(properties
		picture 8604
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 8603) ; wahnDisp3Rm
			(gEgo
				posn: 500 255
				heading: 225
				sel_737:
				init:
				setScaler: Scaler 100 46 363 234
			)
		else
			(gEgo
				posn: 130 266
				heading: 135
				sel_737:
				init:
				setScaler: Scaler 100 46 363 234
			)
		)
		(model init:)
		(wallPics init:)
		(costume init:)
		(d1Exit init:)
		(d3Exit init:)
	)
)

(instance model of GKFeature
	(properties
		nsBottom 216
		sightAngle 360
		BAD_SELECTOR 8618
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 218 262 244 388 215 386 195 291 183
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wallPics of GKFeature
	(properties
		nsLeft 350
		nsTop 96
		nsRight 506
		nsBottom 177
		sightAngle 360
		BAD_SELECTOR 8615
	)
)

(instance costume of GKFeature
	(properties
		nsLeft 254
		nsTop 69
		nsRight 328
		nsBottom 175
		sightAngle 360
		BAD_SELECTOR 8619
	)
)

(instance d1Exit of ExitFeature
	(properties
		nsLeft 88
		nsTop 57
		nsRight 138
		nsBottom 216
		x 125
		y 228
		BAD_SELECTOR 8601
		BAD_SELECTOR 7
	)
)

(instance d3Exit of ExitFeature
	(properties
		nsLeft 518
		nsTop 91
		nsRight 584
		nsBottom 232
		x 546
		y 240
		BAD_SELECTOR 8603
		BAD_SELECTOR 1
	)
)

