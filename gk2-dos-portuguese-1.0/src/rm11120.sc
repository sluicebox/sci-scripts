;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11120)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm11120 0
)

(instance rm11120 of ExitRoom ; "Wittelsbacher Theater: Auditorium"
	(properties
		modNum 1110
		noun 7
		picture 11120
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(cond
			((and (== gPrevRoomNum 11302) (IsFlag 814))
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 169 158
					sel_737: 135
					init:
				)
				(botBackEastExit init:)
			)
			((== gPrevRoomNum 11302)
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 85 156
					sel_737: 135
					init:
				)
				(botMidEastExit init:)
			)
			((and (== gPrevRoomNum 11304) (IsFlag 814))
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 178 67
					sel_737: 135
					init:
				)
				(topBackEastExit init:)
			)
			(else
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 89 58
					sel_737: 135
					init:
				)
				(topMidEastExit init:)
			)
		)
		(super init: &rest)
		(seats init:)
	)
)

(instance seats of GKFeature
	(properties
		noun 1
		modNum 1110
		sightAngle 360
		x 219
		y 249
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 167 199 165 419 171 439 190 435 248 365 333 0 333 0 168
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance botBackEastExit of ExitFeature
	(properties
		x 147
		y 124
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 86 179 86 179 163 115 163
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance botMidEastExit of ExitFeature
	(properties
		x 63
		y 122
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 30 83 96 83 96 161 30 161
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance topBackEastExit of ExitFeature
	(properties
		x 156
		y 30
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 0 193 0 193 61 120 61
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance topMidEastExit of ExitFeature
	(properties
		x 70
		y 30
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 34 0 106 0 106 61 34 61 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

