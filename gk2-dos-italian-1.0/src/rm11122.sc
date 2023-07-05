;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11122)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm11122 0
)

(instance rm11122 of ExitRoom ; "Wittelsbacher Theater: Auditorium"
	(properties
		modNum 1110
		noun 7
		picture 11122
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(cond
			((and (== gPrevRoomNum 11301) (IsFlag 814))
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 458 158
					BAD_SELECTOR: 225
					init:
				)
				(botBackWestExit init:)
			)
			((== gPrevRoomNum 11301)
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 542 156
					BAD_SELECTOR: 225
					init:
				)
				(botMidWestExit init:)
			)
			((and (== gPrevRoomNum 11303) (IsFlag 814))
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 449 67
					BAD_SELECTOR: 225
					init:
				)
				(topBackWestExit init:)
			)
			(else
				(gEgo
					setScale:
					scaleX: 20
					scaleY: 20
					posn: 538 58
					BAD_SELECTOR: 225
					init:
				)
				(topMidWestExit init:)
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
		x 395
		y 247
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 184 208 169 448 162 615 164 615 333 248 332 176 242
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance botBackWestExit of ExitFeature
	(properties
		x 466
		y 123
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 434 87 498 87 498 159 434 159
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance botMidWestExit of ExitFeature
	(properties
		x 552
		y 122
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 517 86 587 86 587 158 517 158
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance topBackWestExit of ExitFeature
	(properties
		x 465
		y 38
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 430 6 500 6 500 70 430 70
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance topMidWestExit of ExitFeature
	(properties
		x 548
		y 30
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 514 1 582 1 582 59 514 59
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

